import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1932 {
    static int[][] DP;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        DP = new int[N+1][N+1];

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            int j = 1;
            st = new StringTokenizer(br.readLine());

            while(j <= i && st.hasMoreElements()) {
                int num = Integer.parseInt(st.nextToken());

                if(j == 1) DP[i][j] = DP[i-1][j] + num;
                else if(j == i) DP[i][j] = DP[i-1][j-1] + num;
                else DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j])+num;

                j++;
            }
        }

        int max = 0;
        for(int num : DP[N]) max = Math.max(max, num);

        System.out.println(max);
    }
}