import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Bottom-up 방식.
public class Boj_1463_bottomUp {
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1] = 0; // 1~N 까지면서 '1'은 3가지 조건연산에 해당되지 않으므로 아래 for 문에 제외하기 위해 미리 초기화

        for (int i = 2; i <= N; i++){
            dp[i] = dp[i-1] + 1; // 동적계획법 기본 점화식입니다. An = An-1 +1

            // 기본 점화식을 베이스로 하고,
            // 추가 예외상황인 2,3 으로 나눈 뒤(+1) 그 나눈 값의 DP 테이블 값을 확인하여 기본 점화식과 비교하여 최소값을 찾습니다.
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] +1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] +1);
        }
        System.out.println(dp[N]);
    }
}