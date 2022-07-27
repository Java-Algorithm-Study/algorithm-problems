import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [15990] 1, 2, 3 더하기 5
 * https://www.acmicpc.net/problem/15990
 *
 * -아이디어
 * 1. dp[i] = i를 만들 수 있는 개수
 * 2. 연속된 숫자를 두 개 이상 사용하지 못한다..
 * 3. dp[i]를 마지막 숫자를 기준으로 파티셔닝하면 dp[5]인 경우에 1 + 3 + 1 / 3 + 2, 2 + 1 + 2 / 2 + 3이 된다.
 * 4. 중복된 숫자가 오지 못하니까 dp[5] = dp[4]에서 2, 3으로 끝나는 숫자 개수 + dp[3]에서 1, 3으로 끝나는 숫자 개수 + dp[2]에서 1, 2로 끝나는 숫자 개수의 합
 * 5.
 *
 * -시간 복잡도
 * 1. O(N)
 *
 * -자료 구조
 * 1. dp[][] 배열에 담는다.
 */

public class Boj15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        long[][] dp = new long[100001][4];
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        int mod = 1000000009;

        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % mod;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % mod;
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % mod).append("\n");
        }

        System.out.println(sb.toString());
    }
}
