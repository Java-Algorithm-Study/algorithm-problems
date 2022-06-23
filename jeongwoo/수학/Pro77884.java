/**
 * [77884] 약수의 개수와 덧셈
 * https://programmers.co.kr/learn/courses/30/lessons/77884
 */

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            int cnt = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    cnt++;
                }
                else if (i % j == 0) {
                    cnt += 2;
                }
            }
            if (cnt % 2 == 0) {
                answer += i;
            }
            else {
                answer -= i;
            }
        }
        
        return answer;
    }
}
