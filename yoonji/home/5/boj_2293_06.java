import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 동전1
// dp[i]는 합이 i가 되는 동전의 경우의 수인데,
// dp[i]를 구할 때 dp[i-1]과 dp[i-2], coin으로 나눠떨어질 떄는 +1 이런식으로 구했는데 계속 순서만 다른 중복이 발생함
// 구하는 방법 자체를 coin만큼을 반복하면서 coin이 사용되는 경우에 따라 dp를 구하는 식으로 바꿔야함.
// 만약 k가 coin보다 크거나 같으면, dp[k-coin]도 더해주는데, 이유는
// coin이 [1,2,5]이고 현재 5에 대한 경우의 수를 구할 때,
// 현재 dp[6]은 1과 2만 추가된 경우의 수므로, dp[6-5]==dp[1]==1 (+5)인 경우의 수 1을 추가한다.
public class boj_2293_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        dp[0] =1; //동전 1개로 가능한 경우
        for (int i=0; i<N; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int k=1; k<=K; k++) {
                if (k>=coin) dp[k] = dp[k]+dp[k-coin];
            }
        }
        System.out.println(dp[K]);
    }
}
