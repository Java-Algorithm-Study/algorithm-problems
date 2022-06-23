/**
 * [12924] 숫자의 표현
 * https://programmers.co.kr/learn/courses/30/lessons/12924
 *
 * -아이디어
 * 1. 연속된 숫자의 합을 구해야 되니까 for문 2번 돈다.
 * 2. 바깥 for는 시작하는 숫자, 안 for는 바깥 숫자에서 1씩 증가해서 sum에 더한다.
 *
 */

public class Pro12924 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int count = 0;

        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = i; j < n + 1; j++) {
                sum += j;
                if (sum > n) {
                    break;
                }
                else if (sum == n) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}

