import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 카드 구매하기2
// 최솟값 비용 구하기
// 카드 N개 살 때의 최솟값 = (카드 N-i개 살 때의 최솟값 + 카드 i개 살때 값) 들의 최솟값
// D[N] = min( D[N-i] + P[i] )
public class boj_16194 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];    // N이 1일 때 dp[2]에 대해 outOfBounds 에러가 나지 않도록 하기 위해
        int[] cardpackPrice = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<N+1; i++) {
            cardpackPrice[i] = Integer.parseInt(st.nextToken());
        }
        // min을 구하는 거니까 각 dp[i]에 팩 한개 사는 경우를 넣어놓고 min을 비교해야됨. 그럼 내부 반복문은 <=i가 아닌, <i까지만 반복해도 됨.
        // 최솟값 구하는 bottom up
        for (int i=1; i<=N; i++) {
            dp[i] = cardpackPrice[i];
            for (int j=1; j<i; j++) {
                dp[i] = Math.min(dp[i], cardpackPrice[j] + dp[i-j]);
            }
        }
        System.out.println(dp[N]);
    }
}
