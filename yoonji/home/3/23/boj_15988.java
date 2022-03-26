import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 점화식
//D[i] = D[i-1] + D[i-2] + D[i-3]
// 계산 시 dp에 저장되는 값은 int 범위를 넘으니 long[]으로 dp 초기화
public class boj_15988 {
    static final long MOD = 1_000_000_009L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            for (int j = 4; j <= N; j++) {
                if (dp[j] > 0) continue; // memoization
                dp[j] = (long) ((dp[j - 1] + dp[j - 2] + dp[j - 3]) % MOD);
            }
            sb.append((long) (dp[N] % MOD)).append("\n");
        }
        System.out.print(sb);
    }
}
