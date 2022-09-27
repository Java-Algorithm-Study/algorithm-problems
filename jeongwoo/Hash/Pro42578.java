import java.util.*;

/*
[42578] 위장
1. 각 의상 종류가 몇 개인지 HashMap에 저장한다.
2. 각 의상별로 입고, 안 입고 -> 모자가 두 종류인 경우 (0, 1, 2) : 0 다 안 입고, 1번 입고, 2번 입고
3. 의상별 개수가 a, b, c라면 a*b*c - 1 (모두 안 입는 경우)
*/

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for (String x : map.keySet()) {
            answer *= (map.get(x) + 1);
        }
        return answer - 1;
    }
}
