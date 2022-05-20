import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11055 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        var st = new StringTokenizer(bf.readLine(), " ");
        int[] dp = new int[N];
        int[] seq = new int[N];
    
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            seq[i] = n;
        }
        
        for (int i = 0; i < N; i++) {
            dp[i] = seq[i];
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    dp[i] = Math.max(seq[i] + dp[j], dp[i]);
                }
            }
        }
        
        long max = -1;
        for (long num : dp)
            if (num > max) max = num;
    
        System.out.println(max);
    }
}
