import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2225 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        long[] dp = new long[N + 1];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[j] = (dp[j - 1] + dp[j]) % 1_000_000_000;
            }
        }
        System.out.println(dp[N]);
        
        bf.close();
    }
}
