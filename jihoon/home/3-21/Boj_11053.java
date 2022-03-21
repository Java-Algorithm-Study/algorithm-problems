import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11053 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        int[] seq = new int[N];
        int[] dp = new int[N];
        String[] temp = bf.readLine().split(" ");
        
        for (int i = 0; i < temp.length; i++)
            seq[i] = Integer.parseInt(temp[i]);
    
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        
        int max = -1;
        for (int length : dp)
            if (length > max) max = length;
    
//        System.out.println(max);
        System.out.println(Arrays.toString(dp));
    }
}