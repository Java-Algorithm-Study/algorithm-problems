import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1,2,3 더하기 5
// counting
// 조건이 있을 때의 경우의수 구하기
// D[N] = N을 만드는 경우의 수
// 1. N이 7이라면, 6에는 +1, 5에는 +2, 4에는 +3
// 2. D[N][i] = N을 만들면서 마지막자리가 i인, 즉 i를 더하는 경우의 수
// EX) D[N][1] = N을 만들기 위해 마지막자리가 1인, 즉 1을 더하는 경우의 수(N-1, N-2, N-3을 만드는 경우 중 마지막 자리가 1이면 안되므로 i가 2,3인 경우의 수만을 구한다.)
public class boj_15990 {
    private static final int MOD = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp= new long[100001][4];  // 미리 초기화하는데, long으로 하지 않으면 안됨...
        dp[1][1] = 1;   // 1
        dp[2][2] = 1;   // 2
        dp[3][1] = 1;   // 2 1
        dp[3][2] = 1;   // 1 2
        dp[3][3] = 1;   // 3

        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 4; j <= n; j++) {
                // N-1
                dp[j][1] = (dp[j - 1][2] + dp[j - 1][3]) % MOD; // N-1에 1을 더해(1로 끝나)야 하니까, 1을 제외한 n-1의 2로 끝나는 경우, 3으로 끝나는 경우
                // N-2
                dp[j][2] = (dp[j - 2][1] + dp[j - 2][3]) % MOD; // N-2에 2을 더해(2로 끝나)야 하니까, 2를 제외한 n-2의 1로 끝나는 경우, 3로 끝나는 경우
                // N-3
                dp[j][3] = (dp[j - 3][1] + dp[j - 3][2]) % MOD; // N-3에 3을 더해(3으로 끝나)야 하니까, 3을 제외한 n-3의 1로 끝나는 경우, 2로 끝나는 경우
            }
            sb.append((dp[n][1]+dp[n][2]+dp[n][3])% MOD).append("\n");
        }
        System.out.println(sb);
    }
}
