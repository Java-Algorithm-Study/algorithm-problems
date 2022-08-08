import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * [11052] 카드 구매하기
 * https://www.acmicpc.net/problem/11052
 *
 * -아이디어
 * 1. dp[i] = i 장 구매할 수 있는 가장 비싼 금액
 * 2. 카드 i 장 구매할 수 있는 경우는 P1팩 + (i-1), P2팩 + (i-2), P3팩 + (i-3), ..., Pi팩
 * 3. dp[i] = max(P1 + dp[i-1], P2 + dp[i-2], P3 + dp[i-3], ..., Pi)
 *
 * -시간 복잡도
 * 1.O(N^2)
 *
 */

public class Boj11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] dp = new int[1001];
        int[] cardPack = new int[n+1];

        for (int i = 1; i <= n; i++) {
            cardPack[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cardPack[j]);
            }
        }

        System.out.println(dp[n]);
        
    }
}
