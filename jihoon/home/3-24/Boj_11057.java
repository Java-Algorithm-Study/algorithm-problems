import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11057 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] dp = new long[N + 1];
        dp[1] = 10;
        dp[2] = 55;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + i * 55) % 10_007;
        }
        System.out.println(dp[N]);
    }
}
