import java.util.*;

/**
 * [12911] 다음 큰 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12911
 *
 * -아이디어
 * 1. n -> 2진수로 변환하고 1의 개수를 저장한다.
 * 2. n보다 큰 수를 while로 돌면서 찾고, 1의 개수를 비교해서 맞으면 while 나온다.
 *
 */

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String binaryN = Integer.toString(n, 2);
        int binaryCount = findOne(binaryN);
        boolean flag = true;
        int target = n + 1;

        while (flag) {
            String convertedTarget = Integer.toString(target, 2);
            int targetCount = findOne(convertedTarget);
            
            if (binaryCount == targetCount) {
                answer = target;
                flag = false;
            }
            
            target++;
        }

        return answer;
    }
    
    private int findOne(String str) {
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '1') {
                count++;
            }
        }
        
        return count;
    }
}
