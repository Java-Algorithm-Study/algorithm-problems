import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 포도주 시식
// 연속 3개의 포도주를 잡지 않도록 하는 것을 어떻게 처리해야할지 고민이 되었다
// 포함한 경우와 포함시키지 않는 경우로 구분해야겠다 생각했다.
// 이를 코드로 구현하는 과정에서 막혔다.
// 포함하는 경우 : dp[i-3] + arr[i-1] +arr[i]와 dp[i-2] + arr[i] : 3전의 최댓값 + -1전+현재 vs 2전의 최댓값+현재
// 포함하지 않는 경우 : dp[i-1]
// 의 max를 찾는다.
// 점화식 : DP[N] = N까지의 포도주 양 최댓값 (자리 N의 포도주를 포함한 경우와 포함하지 않은 경우의 최댓값을 구한다.)
public class boj_2156 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] grapesJuice = new int[N+1];
        // 1. 초기화
        for (int i=1; i<=N; i++) {
            grapesJuice[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = grapesJuice[1];
        // N이 1보다 클 때에만 dp[2]도 설정 가능 -> 연속 2개 해도, 3부터 line28-29처럼 진행하므로 상관없음.
        if (N > 1) dp[2] = grapesJuice[1] + grapesJuice[2];
        // 2. dp구하기
        for (int i=3; i<=N; i++) {
            int includingIMax = Math.max(dp[i-3]+ grapesJuice[i-1]+grapesJuice[i], dp[i-2]+grapesJuice[i]);
            dp[i] = Math.max(dp[i - 1], includingIMax);
        }
        System.out.println(dp[N]);
    }
}
