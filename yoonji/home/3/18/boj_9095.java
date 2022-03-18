import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1,2,3 더하기
// 1 : 1 (1)
// 2 : 2 (1+1, 2)
// 3 : 4 (1+1+1, 1+2, 2+1, 3)
// 4 : 7 (1+1+1+1, 1+1+2, 2+2, 1+3
// 점화식 : D[N] = D[N-1] + D[N-2] + D[N-3]
// 규칙을 통해점화식을 찾아내기 힘들었음
public class boj_9095 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp= new int[12];  // n<11이므로 미리 초기화
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
/*        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;*/
        int forCnt = 0;
        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
//            sb.append(recursion(n)).append("\n");
            // 1. for문 & bottom up
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
//                System.out.println("호출 횟수 체크 " + forCnt++);   // 11번 호출
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }

    // 2. memoize_recursion &  top down
    static int cnt =0;
    static int memoCnt =0;
    static int[] memo = new int[12];
    private static int recursion(int n) {
//        System.out.println("재귀 횟수 체크" + cnt++);   // 87번 호출
        if (memo[n]>0) return memo[n];
//        System.out.println("memoize를 이용하면? " + memoCnt++);  // + memoize를 이용하면 for문까지 들어오는 경우는 6번
        for (int i=n; i>3; i--) {
            memo[i] = recursion(i-1) + recursion(i-2) + recursion(i-3);
        }
        return memo[n];
    }
}
