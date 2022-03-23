import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1912 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] temp = bf.readLine().split(" ");
        int[] seq = new int[N];
        int[] dp = new int[N];
        
        for (int i = 0; i < temp.length; i++)
            seq[i] = Integer.parseInt(temp[i]);
    
        dp[0] = seq[0];
        for (int i = 1; i < N; i++) {
            dp[i] = seq[i];
            dp[i] = Math.max(dp[i - 1] + dp[i], dp[i]);
        }
    
        int max = Integer.MIN_VALUE;
        for (int num : dp)
            if (num > max) max = num;
        
        System.out.println(max);
    }
}