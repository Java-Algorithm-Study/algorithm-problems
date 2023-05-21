package language.java.Programmers;

public class Pro_12924 {
    /*

    이중 포문을 이용하여 문제를 하나씩 탐색해봅니다.
    제일 바깥 포문은 1~N까지 Start라고 생각합니다
    안쪽 반복문에서 Start부터 N까지 루프를 돌면서 연속된 수를 합하며 15가되는 수를 찾습니다.

    */
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        for (int i = start; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum >= n) {
                    if (sum == n) {
                        answer++;
                    }
                    break;
                }

            }
        }
        return answer;
    }
}
