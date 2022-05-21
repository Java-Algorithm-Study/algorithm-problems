import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11722 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        var st = new StringTokenizer(bf.readLine(), " ");
        
        int[] seq = new int[N];
        int[] dp = new int[N];
    
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            seq[i] = n;
        }
        
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (seq[j] > seq[i]) {
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        
        int max = -1;
        for (int length : dp)
            if (length > max) max = length;
        
        System.out.println(Arrays.toString(dp));
        
    }
}
