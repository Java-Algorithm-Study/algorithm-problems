package Implement.String;
import java.util.*;

// 유일성 + 최소성
// 유일한 데이터가 되도록 만드는 키.
// 그 키는 최대한 최소의 갯수로 만들어야한다.
// 즉, 2개와 3개가 가능하다면 더 적은 수!
// 칼럼길이 1~8
// 로우길이 1~20
// 데이터 길이 1~8 (소문자&숫자)
//중복 튜플X
// 1개씩, 2개씩, 3개씩, .. relation.length씩
/*
- 아이디어
1. 자료구조에 칼럼 별로 데이터를 저장한다.  ex) 100,200,300,400,500,600
2. (정렬)
3. 각 size(1~칼럼 수)만큼 반복문을 돌면서, dfs 메서드를 호출한다.
4. dfs: 모든 짝지어질 수 있는 경우의 수를 size(깊이)만큼 구하고,
   - base case: 배열에 들어간 값들을 String으로 이어붙여서 List에 넣으면서 이미 있는 값인지 확인한다.
      - 있으면, Candidate 후보로 되는 것이므로 boolean 배열에 해당하는 칼럼을 true로 표시하고, answer++
      - 이후 size에서는 true인 배열은 pass해서 호출한다.
   + 추가) 유일성을 만족하는 후보키 중 size가 작은 후보키를 포함하는 후보키는 최소성을 위반하는 것이다.
 */
public class prg_후보키 {
//    private static int[] columnsOfCandidate;
    private static List<ArrayList<Integer>> colsOfCandidate = new ArrayList<>();
//    private static boolean[] isCandidate;

    private static boolean[] visited;
//    private static int answer = 0;

    public int solution(String[][] relation) {
//        columnsOfCandidate = new int[relation[0].length];
//        isCandidate = new boolean[relation[0].length];
        for (int columnSize= 1; columnSize <= relation[0].length; columnSize++) {
            visited = new boolean[relation[0].length];
            List<Integer> idxArr = new ArrayList<>(columnSize);
            getCase_Dfs(columnSize, 0, 0, relation, idxArr);
        }
        return colsOfCandidate.size();
    }

    private void getCase_Dfs(int columnSize, int depth, int startIdx, String[][] relation, List<Integer> idxArr) {
        // 후보키인지 아닌지
        if (depth == columnSize) {
//            List<Integer> keys = new HashSet<>();

            // 최소성?
            for(ArrayList<Integer> key : colsOfCandidate) {
                if (idxArr.containsAll(key)) {
                    System.out.println(idxArr + "키는 " + key + "키를 포함합니다.");
                    return;
                }
            }
// 유일성?
            Set<String> keys = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                String key = "";
                for (int idx : idxArr) {
                    key += relation[i][idx];
                }
                if (keys.contains(key)) return;
                keys.add(key);
            }
                // 03, 023 불가능.   13, 023 가능  (size가 작은 후보키가 큰 후보키에 완전 포함되는 경우만 최소성을 위반한 것.
            /*boolean isContains = true;
            Arrays.sort(idxArr);
            String idxStr = Arrays.toString(idxArr).replaceAll("[^0-9]", "");
            for (String candidateKey : columnsOfCandidate) {
                System.out.println("====");
                String sortedKey = Stream.of(candidateKey.split(""))
                        .sorted()
                        .collect(Collectors.joining());
                System.out.println("기존키: "+sortedKey+ ", 새로운 키: "+idxStr);
                if (sortedKey.contains(idxStr)) {
                    if (idxStr.length() < sortedKey.length()) {
                        columnsOfCandidate.remove(candidateKey);
                        columnsOfCandidate.add(idxStr);
                        return;
                    }
                } else if (idxStr.contains(sortedKey)) {
                    if (idxStr.length() < sortedKey.length()) {
                        columnsOfCandidate.remove(candidateKey);
                        columnsOfCandidate.add(idxStr);
                        return;
                    }
                }
            }
            columnsOfCandidate.add(idxStr);
            return;*/
        }

           /* List<String> newCandidate = List.of(idxStr);
            System.out.println("새 후보키");
            for (String s: newCandidate) System.out.print(s+",");
            System.out.println();
            System.out.println("기존 후보키");
            for (String s: columnsOfCandidate) System.out.print(s+",");
            System.out.println("====");*/

            /*List<String> removedKey = new ArrayList<>();
            for (String candidateKey : columnsOfCandidate) {
                String longKey = candidateKey.length() < columnSize? idxStr: candidateKey;
                String shortKey = candidateKey.length() > columnSize? idxStr: candidateKey;
                for (int i=0; i<shortKey.length(); i++) {
                    if (!longKey.contains(shortKey.charAt(i)+""))
                        isContains = false;
                }
                if (isContains) {
                    removedKey.add(longKey);
                    columnsOfCandidate.add(shortKey);

                    if (candidateKey.equals())
                            columnsOfCandidate.remove(shortKey);
                            columnsOfCandidate.add(longKey);
                        }
                    } else {

                    }*/


            /*    for (int idx : idxArr) {
                    for (String candidateKey : columnsOfCandidate) {
                        if (String.valueOf(idx).equals(candidateKey)) break;
                        else isContains = false;
                    }
                    isContains = true;
                }
                if (isContains) return;*/
//            }
//            columnsOfCandidate.add(idxStr);

        // for문을 돌면서 set에 넣는다.
        // for문 : 칼럼 =>
        for (int i=startIdx; i<relation[0].length; i++) {
            if (visited[i]) continue;

            idxArr.add(depth,i);
            visited[i] = true;
            getCase_Dfs(columnSize, depth+1, i+1, relation, idxArr);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        prg_후보키 t = new prg_후보키();
        String[][] info = {{"100","ryan","music","2"}, {"200","apeach","math","2"}, {"300","tube","computer","3"}, {"400","con","computer", "4"}, {"500","muzi","music","3"}, {"600","apeach","music","2"}};
        String[][] info2 = { {"a","1","aaa","c","ng"},
                {"a","1","bbb","e","g"},
                {"c","1","aaa","d","ng"},
                {"d","2","bbb","d","ng"}};
        String[][] info3 = {{"a","1","aaa","c","ng"}, {"b", "1", "bbb", "c", "g"}, {"c", "1", "aaa", "d", "ng"}, {"d", "2", "bbb","d","ng"}};
        int solution = t.solution(info);
        System.out.println(solution);
        System.out.println("전체 후보키: "+prg_후보키.colsOfCandidate);
    }
}