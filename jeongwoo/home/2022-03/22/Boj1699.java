import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [1699] 제곱수의 합
 * https://www.acmicpc.net/problem/1699
 *
 * -아이디어
 * 1. dp[i] = i를 이룰 수 있는 제곱수의 합 중 최소 개수
 * 2. i보다 작은 제곱수들을 다 비교해야 된다.
 * 3. ex) 43 = 6^2 + 2^2 + 1 + 1 + 1도 있지만 5^2 + 3^2 + 3^2이 최소 개수가 된다.
 * 4. 가장 작은 제곱수부터 가장 가까운 제곱수까지 비교하면서 최소 개수를 찾는다.
 * 5. dp[i] = Math.min(dp[i], dp[i - j^2] + 1)
 *
 * -시간 복잡도
 * 1. O(N^2) 이하
 *
 */

public class Boj1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            dp[i] = i;
            for(int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j*j)] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
