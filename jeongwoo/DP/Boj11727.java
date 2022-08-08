import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [11727] 2xn 타일링 2
 * https://www.acmicpc.net/problem/11727
 *
 * -아이디어
 * 1. 맨뒤를 포커스 두고 묶는다.
 * 2. 맨뒤에 올 수 있는 사각형의 경우는 2x1, 2x1 눕혀서 겹치면 2x2 (직사각형 두 개), 2x2 (정사각형 하나)
 * 3. 사각형 길이를 생각해 보면 2x1은 앞에 i - 1 타일링 경우의 수에 더하고, 2x2는 i - 2 타일링 경우의 수에 붙이면 된다.
 * 4. 즉, dp[i] = dp[i - 1] + 2 * dp[i - 2]
 *
 * -시간 복잡도
 * 1. O(N)
 */

public class Boj11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        int mod = 10007;

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int i = 4; i <= 1000; i++) {
            dp[i] = (dp[i-1] + (2 * dp[i-2])) % mod;
        }

        System.out.println(dp[n]);
    }
}
