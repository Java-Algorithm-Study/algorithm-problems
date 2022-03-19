import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [11726] 2xn 타일링
 * https://www.acmicpc.net/problem/11726
 *
 * -아이디어
 * 1. dp[1] = 1, dp[2] =2
 * 2. 그림 그려 보니까 dp[n] = dp[n-1] + dp[n-2]
 * 3. 구한 dp[n]을 10,007로 나눈 나머지를 구한다.
 *
 * -시간 복잡도
 * 1. O(N) 이하..?
 *
 * -틀린 이유
 * 1. dp[1], dp[2]를 초기화하고 시작했는데, 이 경우 dp = new int[n+1]로 잡아 줬기 때문에 n = 1인 경우 out ouf bounds
 * 2. 해결 방법 1: dp = new int[1001]
 * 3. 해결 방법 2: dp[0] = dp[1] = 1로 초기화하고, for문을 2부터 시작.
 */

public class Boj11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        int mod = 10007;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        System.out.println(dp[n]);
    }
}
