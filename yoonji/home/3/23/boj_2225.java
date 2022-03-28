import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 합분해
// 1. dp배열 : DP[K][N] = N을 만들기 위해 정수 K개를 가지고 만드는 경우의 수
//만약 DP[3][1] = 정수 3개를 가지고 1을 만들어야한다면, 한 정수를 미리 지정하고, 정수 2개의 경우로 계산한다.
// 즉,
// DP[2][0] : 2개의 정수로 0을 만들고 + 1
// DP[2][1] : 2개의 정수로 1을 만들고 + 0
// 의 합이다.
// 규칙 찾아서 점화식 정의하기
// DP[3][0] : 3개로 0 만드는 방법 => DP[2][0]
// DP[3][1] : 3개로 1 만드는 방법  => DP[2][0] + DP[2][1]
// DP[3][2] : 3개로 2 만드는 방법 => DP[2][0] + DP[2][1] + DP[2][2]
// 결국, DP[K][N] = DP[K][N-1] + DP[K-1][N] 이다.
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