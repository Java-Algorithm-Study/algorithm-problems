import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 동물원 (DP)
// 점화식 : D[i]는 i번째 칸에 올 수 있는 경우의 수
// 0개를 둘 수 있는 경우, 1개를 왼쪽에/오른쪽에 둘 수 있는 경우를 구분하기위해 2차원 배열로 표현한다.
// D[i][j]는 i번째 칸에 올 수 있는 상황 j의 경우의 수

// 나의 설계 : N일 때 0~N의 사자 갯수를 기준으로 규칙을 찾으려 했다.
//참고 설계 :  N일 때 각 위치를 기준으로 규칙을 찾는다.
/*즉, N=3일 때든 5일 때든, N번째 칸에 0개 두는 경우, 왼쪽에 1개 두는 경우, 오른쪽에 1개 두는 경우를 구한다.
그리고 N은 N-1번째 칸의 경우의 수를 이용하여 구할 수 있다.
만약 N=3일 때
N[3][0]은 2번째 칸의 1인 경우의 수와 2번째 칸의 0인 경우의 수를 더하면 된다.
N[3][1] = N[2][0] + N[2][2]
N[3][2] = N[2][0] + N[2][1]*/
public class boj_1309 {
    final static int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][3];
        // 초기화
        for (int i=0; i<=2; i++) dp[1][i] = 1;
        // dp 계산 (bottom up)
        for (int i=2; i<=N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;    // 0개
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD; // 왼쪽에 1개
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD; // 오른쪽에 1개
        }
        System.out.println((dp[N][0] + dp[N][1] + dp[N][2])% MOD); // 길이 N의 배치 경우의 수는 세 경우를 모두 더해야함.
    }
}
