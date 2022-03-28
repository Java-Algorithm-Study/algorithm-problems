import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 합분해
//DP[K][N] = N을 만들기 위해 정수 K개를 가지고 만드는 경우의 수
public class boj_2225 {
    final static long MOD =  1_000_000_000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K+1][N+1];
        // 초기화
        for (int i=1; i<=K; i++) dp[i][0] = 1;
        // bottomup(for)
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=K; j++) {
                dp[j][i] = (int)((dp[j][i-1] + dp[j-1][i]) % MOD);
            }
        }
        System.out.println(dp[K][N]);
    }
}
