import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1699 {
    
    public static int SumOfSqureNumber(int n) {
        int i = (int) Math.sqrt(n);
        if (i * i == n) return 1;
        int count = 0;
    
        while (n != 0) {
            if (i * i > n)
                i--;
            else {
                n -= i * i;
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
//        System.out.println(SumOfSqureNumber(n));
        
        int[] dp = new int[100001];
    
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
