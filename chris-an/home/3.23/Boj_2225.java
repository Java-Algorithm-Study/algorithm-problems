import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2225 {

    static int [][] DP;
    static final int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // DP 초기화 후, 초기화값 세팅
        DP = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) DP[i][1] = 1; // K(더해야하는 수)는 K가 1일 땐 무조건 1개입니다.
        // 1, 2, 3, 4, 5, 6.....
        for (int i = 1; i <= K; i++) DP[1][i] = i; // N이 1일 경우엔 1<=1 까지라, 무조건 1개입니다.
        // 0+1, 0+0+1, 0+0+0+1 ....

        // dp[N][K] = dp[N-1][K] + dp[N][K-1] 점화식
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                DP[i][j] = ( DP[i][j-1] + DP[i-1][j] ) % MOD;
            }
        }
        System.out.println(DP[N][K]);
    }
}