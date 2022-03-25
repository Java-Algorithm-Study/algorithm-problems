import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        long[] dp = new long[1_000_000];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
    
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
        }
    
        for (int k = 1; k < N + 1; k++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
