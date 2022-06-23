/**
 * [76501] 음양 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/76501
 */

public class Pro76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < signs.length; i++) {
            if (!signs[i]) {
                absolutes[i] *= -1;
                System.out.println(absolutes[i]);
            }
            answer += absolutes[i];
        }
        return answer;
    }
}
