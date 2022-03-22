import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
// 10,20,10,30,20,50 에서
// 10,30,50 보다는 10,20,30,50 이 정답 => 4
// 전 값보다 작은 값이고 수열의 길이수도 더 적은 상태이면 ++
// D[N] = 길이가 N일 때 가장 긴 수열의 갯수
public class boj_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[A + 1];
        for (int i = 1; i <= A; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[A + 1];    //1개~A개
        // 기본으로 모두 배열의 길이는 1
        for (int i = 1; i <= A; i++) dp[i] = 1;

        dp[1] = 1;
        int max = Integer.MIN_VALUE;
        // 이중 for문 : i보다 앞에 위치한 j들과 비교
        for (int i = 2; i <= A; i++) {
            for (int j = 1; j < i; j++) {
                // 1. 뒤의 값(i)이 더 커야 한다.
                // 2. 동시에 크기가 더 큰 값의 부분수열의 길이(dp[i])가 작은 값의 수열길이+1(dp[j]+1)보다 작으면, 부분수열에 포함되지 않은것이므로 +1
                // 1,2 조건 모두 충족 시 부분 수열에 포함됨
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            // 가장 긴 부분 수열 갯수를 return해야하므로
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
