import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1932 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        int[][] dp = new int[N][];
    
        // 첫 번째 숫자 넣기
        int firstNumber = Integer.parseInt(bf.readLine());
        dp[0] = new int[1];
        dp[0] = new int[]{firstNumber};
        
        for (int i = 1; i < N; i++) {
            String[] line = bf.readLine().split(" ");
            dp[i] = new int[line.length];
            
            // dp[i] 배열을 주어진 숫자들로 초기화
            for (int k = 0; k < line.length; k++) {
                dp[i][k] = Integer.parseInt(line[k]);
            }
    
            // 삼각형에서 첫 번째 숫자 처리
            dp[i][0] = dp[i - 1][0] + dp[i][0];
            
            // 삼각형에서 중간 숫자 처리
            for (int j = 1; j < dp[i].length - 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + dp[i][j], dp[i - 1][j] + dp[i][j]);
            }
            
            // 삼각형에서 마지막 숫자 처리
            dp[i][dp[i].length - 1] = dp[i - 1][dp[i - 1].length - 1] + dp[i][dp[i].length - 1];
        }
    
        int max = Integer.MIN_VALUE;
        for (int num : dp[dp.length - 1]) {
            if (num > max) max = num;
        }
        System.out.println(max);
    }
}
