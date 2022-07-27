import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [16194] 카드 구매하기 2
 * https://www.acmicpc.net/problem/16194
 *
 * -아이디어
 * 1. dp[i] = i 장 구매할 수 있는 최소 금액
 * 2. 카드 i 장 구매할 수 있는 경우는 P1팩 + (i-1), P2팩 + (i-2), P3팩 + (i-3), ..., Pi팩
 * 3. dp[i] = max(P1 + dp[i-1], P2 + dp[i-2], P3 + dp[i-3], ..., Pi)
 * 4. 11052와 접근은 똑같지만 최소 금액이므로 dp 배열을 MAX_VALUE로 초기화한다.
 * 
 * -시간 복잡도
 * 1.O(N^2)
 *
 */

public class Boj16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] dp = new int[1001];
        int[] cardPack = new int[n+1];
        dp[1] = cardPack[1];

        for (int i = 1; i <= n; i++) {
            cardPack[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + cardPack[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
