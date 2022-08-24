import java.util.*;

/**
 * [17687] N진수 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17687
 *
 * -아이디어
 * 1. Integer.toString()을 사용해서 m * t까지의 n진법 숫자를 구한다. -> 무조건 m * t번 째 숫자보다는 작으니까.
 * 2. charAt으로 튜브의 순서에 있는 숫자를 가지고 온다.
 *
 */

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        int total = m * t;
    
        for (int i = 0; i <= total; i++) {
            sb.append(Integer.toString(i, n));
        }
        
        String convertNumber = sb.toString();
        sb.setLength(0);
        
        int start = p;
        for (int i = 0; i < t; i++) {
            sb.append(convertNumber.charAt(start - 1));
            start += m;
        }
        
        return sb.toString().toUpperCase();
    }
}
