import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 제곱수의 합
public class boj_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 1. 초기화
        int[] dp = new int[N+1];
        dp[1] = 1;
        // 2. dp[i] = i를 만드는 제곱 수들의 최소항 개수
        for (int i=2; i<=N; i++) {
            dp[i] = i;  // 1의 제곱의 항 개수로 초기화
            for (int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i-(j*j)]+1, dp[i]);   // 제곱근이 i보다 작을 때만 제곱근이 적용되서 최솟값일 dp[i-(j*j)]에 +1 (같은 수의 제곱근이나 1의 제곱근인 경우 1가지) 과 1의 제곱으로 구성된 항개수 dp[i] 비교
            }
        }
        // N=6일 때
        // i=4
        // j=1: dp[4] = min(dp[4-1^2]+1, dp[4]) => dp[3] + 1(1의 제곱),  1^2 *4
        // j=2: dp[4] = min(dp[4-2^2]+1, dp[4]) => dp[0] + 1(2의 제곱), 1^2 * 4
        // ..
        // i=5
        // j=1: dp[5] = min(dp[5-1^2]+1, dp[5]) => dp[4] + 1(1의 제곱),  1^2 *5 => 2^2 + 1^2 => 2개
        // j=2: dp[5] = min(dp[5-2^2]+1, dp[5]) => dp[1](2의 제곱) + 1(1의 제곱), 2 => 2개

        /** 내 풀이
        for (int i=1; i<=3; i++) dp[i] = i;
        for (int i=2; i*i<=N; i++) {    // 제곱이 될 수
            dp[i*i] = 1;    // 제곱의 수는 항의 최소 개수가 1 ex) 2*2 = 4
            for (int j=i*i+1; j<(i+1)*(i+1); j++) {
                if (j > N) break;
                dp[j] = dp[i*i] + dp[j-(i*i)];
            }
        }*/
        System.out.println(dp[N]);
    }
}
