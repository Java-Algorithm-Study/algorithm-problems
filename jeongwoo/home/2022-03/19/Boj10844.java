import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [10844] 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 *
 * -아이디어
 * 1. dp[i][j] = j로 시작하는 길이가 i인 계단 수의 개수
 * 2. dp[3][1]: 123, 121, 101 / dp[3][2]: 232, 212, 210, 234 / dp[3][3]: 343, 345, 321, 323 / ... / dp[3][8]: 898, 878, 876 / dp[3][9]: 987, 980
 * 3. 규칙을 찾아보면 dp[i][1] = dp[i-1][2] + dp[i-2][1] / dp[i][2] = dp[i-1][1] + dp[i-1][3] .. / dp[i][9] = dp[i-1][8]
 *
 * -시간 복잡도
 * 1. O(N)
 *
 * -자료 구조
 * 1. dp[][]
 */

public class Boj10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[101][10];
        int mod = 1000000000;

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
            if (i == 9) {
                dp[2][i] = 1;
            }
            else {
                dp[2][i] = 2;
            }
        }

        for (int i = 3; i <= 100; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 1) {
                    dp[i][j] = (dp[i-1][j+1] + dp[i-2][j]) % mod;
                }
                else if (j == 9) {
                    dp[i][j] = dp[i-1][j-1] % mod;
                }
                else {
                    dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) % mod;
                }
            }
        }

        long sum = 0;

        for (int i = 1; i <= 9; i++) {
            sum = (sum + dp[n][i]) % mod;
        }

        System.out.println(sum);

    }
}
