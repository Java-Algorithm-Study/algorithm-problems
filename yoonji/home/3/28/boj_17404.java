import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리2
// 주의 : 1번째와 N번째 또한 같은 색이면 안된다!
// 점화식 dp[i] = 이전/다음집과 다른 색으로 칠해지는 최소 비용
/* 로직
 1. 색이 어떤 값이냐에 따라 1번째 집에 지정 색의 다른 색들은 최대비용을 넣어놓는다.
 2. N번째 집의 최소비용을 구할 때 색이 i인 경우를 제외시켜야 한다. (1번째 집과 같은 색이므로)
*/
public class boj_17404 {
    public static void main(String[] args) throws IOException {
        // 1. 초기화
        int minPrice = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];   // N개의 집, 3색(RGB)
        int[][] rgbPrice = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            rgbPrice[i][0] = Integer.parseInt(st.nextToken());
            rgbPrice[i][1] = Integer.parseInt(st.nextToken());
            rgbPrice[i][2] = Integer.parseInt(st.nextToken());
        }
        // 2. 1번째 집의 색 정하고 2~N-1 최소값 구하기
        for (int i = 0; i < 3; i++) {
            // 2-1. 정해진 색상을 제외한 1번째 집의 비용은 최대비용으로 설정하기 (선택되지 않도록)
            for (int j = 0; j < 3; j++) {
                if (i == j) dp[1][j] = rgbPrice[0][i];
                else dp[1][j] = 1000 * 1000 + 1;
            }
            // 2-2. 모든집에 대해 처리
            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + rgbPrice[j-1][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + rgbPrice[j-1][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + rgbPrice[j-1][2];
            }
            // 2-3. 특정 색(i)을 골랐을 때 N의 최소 비용들 중 최소값을 구한다. (i번째와 같은 색의 N번째 집은 pass)
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                minPrice = Math.min(minPrice, dp[N][j]);
            }
        }
        System.out.println(minPrice);
    }
}
