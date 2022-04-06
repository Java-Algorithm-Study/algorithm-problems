import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오르막수 (DP)
// DP[N] = 길이 N개의 오름차순 갯수(경우의 수)
// 이전에 풀었던 문제(아마 boj_10844)와 유사한 로직이라 풀 수 있었던 것 같음 -> 내가 직접 푼, 혹은 참고하며 푼 문제를 다시 풀어보는 것만으로도 좋을듯함.
public class boj_11057 {
    final static int MOD =  10_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][11];
        // 초기화
        for (int i=0; i<=9; i++) dp[1][i] = 1;
        // 로직처리
        int ans = 0;
        for (int i=2; i<=N; i++) {
            for (int j=9; j>=0; j--) {
                dp[i][j] = (dp[i-1][j] + dp[i][j+1])% MOD;
//                if (i==N) ans+= dp[N][j];
            }
        }
        for (int i=0; i<=9; i++) ans += dp[N][i];
        System.out.println(ans % MOD);
    }
}
