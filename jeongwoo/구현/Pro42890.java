import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [42890] 후보키
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 *
 * -아이디어
 * 1. 컬럼 1개 ~ 8개에서 8C1, 8C2, ... 를 진행한다. -> 컬럼 개수 C 1 ~ 컬럼 개수 C 컬럼 개수
 * 2. 만들어진 조합으로 로우를 돌면서
 * 3. 조합으로 만약 학번, 이름을 뽑았다면 로우를 돌면서 맵에 학번이름(100ryan)을 넣는다.
 * 4. 맵에 다 넣었을 때, 릴레이션 length와 같다면 -> 유일성 만족
 * 5. 유일성 만족한다면 최소성 체크해야 된다.
 * 6. 후보키의 후보가 되는 것들이 idxArr에 인덱스로 담겨져 있다.
 * 7. idxArr이 만약 123인데, 이미 후보키 안에 1이 있다면 이건 최소성을 만족하지 못한다. 
 * 8. 후보키들의 집합 원소들이 다른 후보키의 부분집합이 되면 안 된다. 
 * 9. 후보키의 후보들을 idxArr라고 했을 때, 후보키들이 담긴 list가 idxArr에 있으면 안 된다.
 * 10. 최소성 만족한다면 list에 idxArr 값들을 넣는다.
 *
 * -자료 구조
 * 1. List<String> keyList : 후보키들 저장
 * 2. Set<String> keys : 유일성 판별
 * 
 */

public class Pro42890 {
    private static boolean[] visited;
    private static int answer = 0;
    private static List<String> keyList = new ArrayList<>();

    public static void main(String[] args) {
//        String[][] input = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        String[][] input = {{"a","1", "aaa","c","ng"}, {"b","1","bbb","c","g"}, {"c","1","aaa","d","ng"}, {"d","2","bbb","d","ng"}};
        System.out.println(solution(input));
    }

    public static int solution(String[][] relation) {
        for (int columnSize = 1; columnSize <= relation[0].length; columnSize++) {
            visited = new boolean[relation[0].length];
            int[] idxArr = new int[columnSize];
            dfs(columnSize, 0, 0, relation, idxArr);
        }

        return answer;
    }

    private static void dfs(int columnSize, int depth, int startIdx, String[][] relation, int[] idxArr) {
        if (depth == columnSize) {
            Set<String> keys = new HashSet<>();
            
            for (int i = 0; i< relation.length; i++) {
                String key = "";
                
                for (int idx: idxArr) {
                    key += relation[i][idx];
                }
                
                keys.add(key);
            }
            
            // 최소성 만족한다면 
            if (keys.size() == relation.length) {
                // 유일성 체크
                String tempIdx = "";
                for (int idx: idxArr) {
                    tempIdx += idx;
                }

                boolean isMinimality = true;
                for (String s : keyList) {
                    String[] sArr = s.split("");
                    
                    int cnt = 0;
                    for (String x : sArr) {
                        if (tempIdx.contains(x)) {
                            cnt++;
                        }
                    }
                    
                    if (cnt == s.length()) {
                        isMinimality = false;
                    }
                }

                if (isMinimality) {
                    keyList.add(tempIdx);
                    answer++;
                }
            }
            return;
        }

        for (int i = startIdx; i < relation[0].length; i++) {
            if (visited[i]) {
                continue;
            }
            idxArr[depth] = i;
            visited[i] = true;
            dfs(columnSize, depth + 1, i + 1, relation, idxArr);
            visited[i] = false;
        }
    }
}
