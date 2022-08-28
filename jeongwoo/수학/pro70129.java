import java.util.*;

/**
 * [70129] 이진 변환 반복하기
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 *
 * -아이디어
 * 1. 입력 s에서 0의 개수를 세고 저장한다.
 * 2. s에서 0을 없애고, 그 길이로 이진 변환한다.
 * 3. 1 ~ 2를 s가 "1"이 될 때까지 반복한다.
 *
 */

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int totalCount = 0;
        
        while (!s.equals("1")) {
            // 제거할  0의 개수 더하기
            zeroCount += readZeroCount(s);
            
            // 이진 변환 결과
            s = removeAndConvert(s);

            // 총 변환 횟수
            totalCount++;
        }
        
        answer[1] = zeroCount;
        answer[0] = totalCount;
        
        return answer;
    }
    
    private int readZeroCount(String s) {
        int count = 0;
                
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            
            if (now == '0') {
                count++;
            }
        }
        return count;
    }
    
    private String removeAndConvert(String input) {
        // 0 제거
        String str = input.replaceAll("0", "");
        
        // 0 제거 후 길이
        int length = str.length();
        
        // 이진 수 변환
        return Integer.toBinaryString(length);

    }
}
