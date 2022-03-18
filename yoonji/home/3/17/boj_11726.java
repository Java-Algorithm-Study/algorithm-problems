//2×n 타일링

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// fibo 원리 이용 (1 -> 2 -> 3 -> 5 -> 8)
// but 값을 10007로 나눠야함
public class boj_11726 {
    public static void main(String[] args) throws IOException {
        // 반복문 bottomup 이용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];    // ※ N이 1인 경우 dp[2]까지 있어야하므로 int[3]
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;  // 값을 10007로 나눈 나머지
        }
        System.out.println(dp[N]);
    }
}
