import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149 {
    
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ordCnt = Integer.parseInt(br.readLine());
        dp = new int[ordCnt + 1][3];
        
        for (int i = 1; i <= ordCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            dp[i][0] = R + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = G + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = B + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        System.out.println(Math.min(dp[ordCnt][0],Math.min(dp[ordCnt][1], dp[ordCnt][2])));
    }
}