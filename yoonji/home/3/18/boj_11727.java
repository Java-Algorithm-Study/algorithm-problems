import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2*n 타일 2
public class boj_11727 {
    private static final int MOD = 10007;   //modulo(나머지연산)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];    // N이 1일 때 dp[2]에 대해 outOfBounds 에러가 나지 않도록 하기 위해
        dp[1] = 1;
        dp[2]= 3;
        for (int i=3; i<=N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]*2) % MOD;
        }
        System.out.println(dp[N]);
    }
}
