import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [2193] 이친수
 * https://www.acmicpc.net/problem/2193
 *
 * -아이디어
 * 1. dp[i] = dp[i][0] + dp[i][1], 0으로 끝나는 i자리 이친수 개수 + 1로 끝나는 i자리 이친수 개수
 * 2. dp[i-1]이 0으로 끝나면 0, 1 두 개 붙일 수 있고, 1로 끝나면 0만 붙일 수 있다.
 * 4. 즉, 0은 아무 곳에나 붙을 수 있지만 1은 뒤가 0으로 끝나는 곳에만 붙일 수 있다.
 * 3. 즉, dp[i][0] = dp[i-1][0] + dp[i-1][1], dp[i][1] = dp[i-1][0]
 *
 * -시간 복잡도
 * 1. O(N)
 *
 * -자료 구조
 * 1. dp[][]
 * 
 * 자료형을 생각 잘해야 되겠다..
 */

public class Boj2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[91][2];

        dp[1][0] = 1;
        dp[2][0] = 1;

        for (int i = 3; i <= 90; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[n][0] + dp[n][1]);
    }
}
