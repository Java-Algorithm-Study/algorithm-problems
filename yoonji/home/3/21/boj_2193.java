import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이친수
// N자리 이친수의 개수를 구하자.
// D[N] : N자리 이친수 갯수
// 자릿수 N의 자리는 1밖에 못온다.
// 자릿수 N인 자릿값이 1 앞에는 0밖에 못온다.
// 0 앞에는 1, 0 둘다 올 수 있다.
// 자릿수와 자릿값을 위해 이차원 배열로 나타낸다.
public class boj_2193 {
    static int N;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][2]; // 0과 1
        // 마지막 자릿수는 경우의 수 1?
        dp[1][0] =1L;
        dp[1][1] =1L;
        for (int i = 0; i <= 1; i++) {  // N의 자릿값(0,1)을 돌며
            recur(N, i);
        }
        System.out.println(dp[N][1]);
    }

    private static long recur(int digit, int value) {
        if (digit == 1) return dp[digit][value];    // 자릿수가 1인 경우
        if (digit == N && value == 0) return dp[digit][value];   // 자릿수가 N이면서 값이 0인 경우
        if (dp[digit][value] == 0) {
            if (value == 1) dp[digit][value] = recur(digit-1, 0);   // 1이면 앞에 0만 올 수 있음
            else dp[digit][value] = recur(digit-1, 0) + recur(digit-1, 1);  // 0이면 1과 0 올 수 있음
        }
        return dp[digit][value];
    }
}
