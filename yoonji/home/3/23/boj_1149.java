import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// d[i][0] = min( d[i-1][1], d[i-1][2] ) + R
// d[i][1] = min( d[i-1][0], d[i-1][2] ) + G
// d[i][2] = min( d[i-1][0], d[i-1][1] ) + B
public class boj_1149 {
    static int[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][3];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 1. 초기화
        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        dp[1][0] = R;
        dp[1][1] = G;
        dp[1][2] = B;
        // 2. 로직처리
        for (int i=2; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B;
        }
        // 내 풀이 : else 구문에서 i+1을 어떻게 구하지란 생각에서 막혔다.. 문제에서 조건이 3개나 주어졌지만 결론은 앞 집과 같은 색을 안입히면 됐다.
        /*for (int i=3; i<=N; i++) {
            dp[i][0] = recur(i-1, 1)
            if (i==N) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + paintPrice[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + paintPrice[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + paintPrice[i][2];
            } else {
                dp[i][0] =  Math.min(Math.min(dp[i-1][1], dp[i-1][2]), Math.min(dp[i+1][1], dp[i+1][2])) + paintPrice[i][0];
                dp[i][1] =  Math.min(Math.min(dp[i-1][0], dp[i-1][2]), Math.min(dp[i+1][0], dp[i+1][2])) + paintPrice[i][1];
                dp[i][2] =  Math.min(Math.min(dp[i-1][0], dp[i-1][1]), Math.min(dp[i+1][0], dp[i+1][1])) + paintPrice[i][2];
            }
        }*/
        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}
