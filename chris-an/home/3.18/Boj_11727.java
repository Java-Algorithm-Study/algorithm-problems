import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11727 {
    /*
        규칙 찾기.
        1. 먼저 그려보기
            2 * 2 = 3
            2 * 3 = 5
            2 * 5 = 11
        2. 그리고 규칙성 찾기
            2-1. 그려보니 피보나치수열인가? 하였는데, 2 * 5 가 11이 나와서 피보나치 규칙이 아닌 걸 알게됨.
            2-2. 소수의 규칙인가? 아니다. 일단 8을 넣었을 때, 소수가 나오지 않는다.
            2-3. 2 * 1 이 1이니깐, 1 -> 3 -> 5 -> 11 규칙이 뭐가 있는지 다시 생각.
            2-4. An의 수를 구하기위해 An-1 수를 곱했는데, 모든 항에서 1씩 더 많던가? 더 적던가 함.
            2-5. 일단 테스트케이스인, 8과 12를 An-1에서 홀수 n 번째면 1을 빼주고 짝수면 1을 더해준다.
            2-6. 점화식 루틴이 보임.
            2-7. (짝수) An = An-1 * 2 + 1
                 (홀수) An = An-1 * 2 - 1
                 점화식으로 표현이 가능.
     */
    static int dp []; // 메모이제이션
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1] = 1; // N = 1,  2*1=> 1개

        for (int i = 0; i < dp.length; i++) {
            if (i == 0) dp[i] = i;
            else if (i == 1) dp[i] = i;
            else {
                if (i % 2 == 1) { // 홀수 일때는 '-1'
                    dp[i] = (dp[i-1] * 2 - 1) % 10007;
                }else { // 짝수 일때는 '+1'
                    dp[i] = (dp[i-1] * 2 + 1) % 10007;
                }
            }

        }
        System.out.println(dp[N] % 10007);
    }
}
