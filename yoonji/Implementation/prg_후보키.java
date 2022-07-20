package Implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 유일성: 식별되어야한다.
// 최소성: 모든 튜플을 유일하게 식별하는데 필요한 속성들로만 구성
//  - {이름,전공}이 후보키라면, {이름,전공,학년}은 X
//  - {이름,학번}이 후보키O, {이름,전공} 후보키O
//  - {학번} 후보키O, {이름,전공} 후보키O

// 칼럼 길이 8이하, 로우 길이 20이하, 문자열 8이하
// - 아이디어
// size=1부터 relation.length까지 키워나가면서, 조화를 만든다. (Integer로 Set에 put)   - by dfs
//   - size를 채웠다면 (base case)
//     - 최소성 check : 해당하는 keySet이 이미 candidateKeySet을 포함하는지?
//     - 유일성 check : 해당하는 keySet의 relation 튜플 조합(String)으로 Set에 add하면서 데이터가 겹친다면 유일성 만족 X
//   - size를 안채웠다면
//     - size를 하나씩 키워가며 모든 경우의 수를 set에 더해간다.
public class prg_후보키 {
    // 데이터의 최소성 확인 자료구조 for 칼럼
    List<HashSet<Integer>> candidateKey;

    public int solution(String[][] relation) {
        candidateKey = new ArrayList<>();
        int colLen = relation[0].length;

        // 크기 1부터 colSize까지 순회하며 keySet
        for (int colSize = 1; colSize<= colLen; colSize++) {
            makeKeySet_dfs(0, colLen, 0, colSize, new HashSet<>(), relation);
            for (HashSet<Integer> key : candidateKey) {
                System.out.println("----------현재 후보키: "+key);
            }
        }
        System.out.println(candidateKey.toString());
        return candidateKey.size();
    }
    // 현재 컬럼, 컬럼갯수, 현재 컬럼사이즈, 컬럼사이즈, 추가된 컬럼key(set), 기존 배열
    private void makeKeySet_dfs(int currCol, int colLen, int currColSize, int maxColSize, HashSet<Integer> keySet, String[][] relation) {
        if (currColSize == maxColSize) {
            System.out.println("\n----------현재 size "+maxColSize +"만큼 모여진 키: "+keySet+"는 후보키가 될 것인가?");

            // 최소성
            for (HashSet<Integer> key : candidateKey) {
                // 현재 추가된 keySet이 기존의 keySet을 갖고 있다면 최소성 어긋남.
                if (keySet.containsAll(key)) {
                    System.out.println("기존"+ key+"를 포함하는 신규 keySet이라 최소성에 만족하지 않습니다.");
                    return;
                }
                System.out.println(keySet+"는 기존 candidateKey를 포함하지 않았으므로 최소성에 만족합니다.");
            }
            // 유일성 (key의 합으로, 중복되는 튜플이 없어야함)
            if (isUnique(keySet, relation)) {
                candidateKey.add(keySet);
                System.out.println("현재 칼럼집합의 튜플들이 유일성까지 만족하므로 "+keySet+ "은 후보키입니다.\n");
            }
            return;
        }

        for (int i=currCol; i<colLen; i++) {
            // size 만큼의 칼럼idx   ex) <1,2>
            HashSet<Integer> newKeySet = new HashSet<>(keySet); //Set으로 선언하면 안됨..
            newKeySet.add(i);   //새  Set에 넣거나, 기존 Set에 넣고 자기호출 후 빼거나
            makeKeySet_dfs(i+1, colLen, currColSize+1, maxColSize, newKeySet, relation);
        }
    }
    private boolean isUnique(HashSet<Integer> newKeySet, String[][] relation) {
        Set<String> values = new HashSet<>();
        for (int i=0; i<relation.length; i++) {
            String tuples = "";
            for (Integer k: newKeySet) {
                tuples +=relation[i][k];
            }
            if (values.contains(tuples)) return false;
            else values.add(tuples);
        }
        return true;
    }


    public static void main(String[] args) {

    }
}