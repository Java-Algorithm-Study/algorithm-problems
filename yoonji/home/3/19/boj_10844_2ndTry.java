import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// dp[i][j] = 자릿수가 i이고 j로 시작하는 계단수의 개수  ex) j=1이면, 길이가 i이고 1로 시작하는 계단수의 개수
// 이해 후 다시 푼 code (bottomup + 반복문)
public class boj_10844_2ndTry {
    static long MOD = 1_000_000_000;   // modulo
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];

        // 1. 길이 1인 계단수는 각 j로 시작하는 게 1개의 경우 뿐 ex) 1,2,3,..,9
        for (int i=0; i<=9; i++) dp[1][i] = 1L;

        // 2. i=2부터 N까지 반복문돌면서 dp[i][j]는 dp[i-1][j-1] + dp[i-1][j+1] (j가 0,9일 때 제외)
        for (int i=2; i<=N; i++) {
            for (int j=0; j<=9; j++) {
                if (j==0) dp[i][j] = (dp[i-1][1]) % MOD;
                else if (j==9) dp[i][j] = (dp[i-1][8]) % MOD;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
        }
        int ret = 0;
        for (int i=1; i<=9; i++) {  //N길이에서 1~9로 시작하는 경우의 수
            ret += dp[N][i];
        }
        System.out.println(ret % MOD);
    }
}