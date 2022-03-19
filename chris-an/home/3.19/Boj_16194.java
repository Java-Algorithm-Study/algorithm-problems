import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16194 {
    // 지난 주와 같은 문제지만, 정답 비율이 높은 이유는
    // 최대 값 부분을 최소값으로 바꾼 상태에서 DP 테이블에 저장하면서
    // 중복되는 부분문제 해결을 하면 되는 문제인 거 같습니다.
    static int dp []; // DP 테이블
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int P [] = new int[N+1];
        int dp [] = new int[N+1];
        for (int i = 1; i < P.length; i++) {
            dp[i] = P[i] = Integer.parseInt(st.nextToken());

        }
        for (int i = 1; i < dp.length; i++) { // i 번째 루프는? 카드 i개 일 때? 최소비용
            for (int k = 1; k <= i; k++) {
                dp[i] = Math.min(dp[i], P[k] + dp[i - k]);
            }
        }
        System.out.println(dp[N]);
    }
}
