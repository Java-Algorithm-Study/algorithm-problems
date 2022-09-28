import java.util.*;

/*
* [42584] 주식 가격
*
* https://school.programmers.co.kr/learn/courses/30/lessons/42584
* 
* 접근 방법
* 1. 현재 가격보다 더 작은 값이 있다면 그 값이 나올 때까지만 sec++
* 2. 현재 가격은 맨끝이 아닌 이상 일단 최소 1초는 유지된다.
*
*/

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            int now = prices[i];
            int sec = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int next = prices[j];
                sec++;
                if (now > next) {
                    break;
                }
            }
            answer[i] = sec;
            
        }
        return answer;
    }
}
