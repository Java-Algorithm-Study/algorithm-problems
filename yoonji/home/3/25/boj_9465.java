import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 스티커
public class boj_9465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            // 1. 초기화
            int[][] stickers = new int[3][N + 1];
            dp = new int[3][N + 1];
            for (int j=1; j<=2; j++) {
                int idx = 0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()) stickers[j][++idx] = Integer.parseInt(st.nextToken());
            }
            dp[1][1] = stickers[1][1];
            dp[2][1] = stickers[2][1];

            // 2. dp 구하기 : 현재 위치에서는 각 크로스되는 층의 "전, 전전 최댓값"만 고려하면 된다.
            // 더 전의 것만을 고려하게 되면 전과 전전의 값을 고려하지 못한 최댓값이 된다.
            for (int k=2; k<=N; k++) {
                dp[1][k] = Math.max(dp[2][k - 1], dp[2][k - 2]) + stickers[1][k];
                dp[2][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + stickers[2][k];
            }
            /* 내 풀이(시간초과) : 해당 값에 대해 모든 dp의 최댓값을 구하는 방식
            for (int k=2; k<=N; k++) {
                int max = getCommonMaxDp(k);
                dp[1][k] = Math.max(max, dp[2][k-1]) + stickers[1][k];
                dp[2][k] = Math.max(max, dp[1][k-1])+ stickers[2][k];
            }*/
            sb.append(Math.max(dp[1][N], dp[2][N])).append("\n");
        }
        System.out.println(sb);
    }

    private static int getCommonMaxDp(int k) {
        int max = 0;
        for (int i=1; i<=2; i++)
            for (int j=1; j<k-1; j++) {
                max = Math.max(max, dp[i][j]);
            }
        return max;
    }
}
