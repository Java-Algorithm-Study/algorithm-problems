import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// dp[n] = N번째 까지의 최대합
// dp[i] = i-1번째까지의 최대합+num[i]와 num[i]중 더 큰값
public class boj_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[N];
        int[] dp = new int[N];
        // 1. 초기화
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int max = dp[0] = nums[0];  // max와 dp[0]은 0번째 값으로 초기화
        // 2. dp 구하기
        for (int i=1; i<N; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]); // 최댓값도 같이 저장해놓기.
        }
        System.out.println(max);
    }
}
