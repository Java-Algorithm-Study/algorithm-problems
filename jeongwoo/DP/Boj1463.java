import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [1463] 1로 만들기
 * https://www.acmicpc.net/problem/1463
 *
 * -아이디어
 * 1. dp[1] = 0. 1은 1이니까.
 * 2. dp[n] = dp[n-1] + 1
 * 3. 2의 배수이거나 3의 배수일 때는 dp[n/2], dp[n/3]과 비교한다.
 *
 * -시간 복잡도
 * 1. O(N)
 *
 */

public class Boj1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[1] = 0;

        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
