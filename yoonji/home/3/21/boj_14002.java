import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 4
public class boj_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[A + 1];
        int[] dp = new int[A + 1];    //1개~A개
        // 1.초기화
        for (int i = 1; i <= A; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= A; i++) dp[i] = 1;
        int max = 1;    // input이 최솟값 1일 때 for문을 돌지 않을 수 있으므로 max 값은 1로 초기화.

        // 2. dp 값 구하기 : 이중 for문 : i보다 앞에 위치한 j들과 비교
        for (int i = 2; i <= A; i++) {
            for (int j = 1; j < i; j++) {
                // 1. 뒤의 값(i)이 더 커야 한다.
                // 2. 동시에 크기가 더 큰 값의 부분수열의 길이(dp[i])가 작은 값의 수열길이+1(dp[j]+1)보다 작으면, 부분수열에 포함되지 않은것이므로 +1
                // 1,2 조건 모두 충족 시 부분 수열에 포함됨
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            // 가장 긴 부분 수열 갯수를 알아야하므로
            max = Math.max(max, dp[i]);
        }
        // 답 출력 : 수열길이 + 부분 수열 출력
        System.out.println(max);
        List<Integer> ans = new ArrayList<>();
        for (int i=dp.length-1; i>=1; i--) {
            if (max == 0) break;
            if (max == dp[i]) {
                ans.add(nums[i]);
                max--;
            }
        }
        for (int i=ans.size()-1; i>=0; i--)
            System.out.print(ans.get(i) +" ");
    }
}