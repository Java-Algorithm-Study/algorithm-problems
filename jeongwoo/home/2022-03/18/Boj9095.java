import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [9095] 1, 2, 3 더하기
 * https://www.acmicpc.net/problem/9095
 *
 * -아이디어
 * 1. dp[1] = 1, dp[2] = 2, dp[3] = 4
 * 2. dp[4]를 구하는데, 맨 뒤에 오는 숫자를 공통으로 묶는다.
 * 3. (..+ 1, ..+ 2, ..+ 3)으로 묶으면 +1은 바로 이전 숫자, +2는 전전 숫자, +3은 전전전 숫자의 개수인 것을 알 수 있다.
 *
 * -시간 복잡도
 * 1. O(N)
 *
 */

public class Boj9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb.toString());
    }
}
