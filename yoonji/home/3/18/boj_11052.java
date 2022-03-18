import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카드 구매하기
// 배열에 들어갈 값: index개 구할 때 최대 비용
// 카드 N개 구매할 때 비용의 최댓값을 구한다.
public class boj_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];    // N이 1일 때 dp[2]에 대해 outOfBounds 에러가 나지 않도록 하기 위해
        int[] cardpackPrice = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<N+1; i++) {
            cardpackPrice[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        // 카드팩 i일 때 최대 값구한다.
        // ex) i=3 :3개의 카드를 구매하는 경우
        for (int i=1; i<=N; i++) {
            // 카드팩 i를 만드는 경우의 수를 돌며 최댓값을 비교하여 구한다.
            // ex) j=1 : dp[2]+P[1]-> 카드2개의최댓값+카드1개값 / j=2 : dp[1]+P[2]-> 카드1개의 최댓값+카드2개값 / j=3 : dp[0]+P[3] ->P3가격
            for (int j=1; j<=i; j++)  {
                dp[i] = Math.max(dp[i], dp[i - j] + cardpackPrice[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
