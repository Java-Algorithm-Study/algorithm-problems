import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149 {

    static int [][] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ordCnt = Integer.parseInt(br.readLine());
        DP = new int[ordCnt+1][4];

        for (int i = 1; i <= ordCnt;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            DP[i][1] = R + Math.min(DP[i-1][2], DP[i-1][3]);
            DP[i][2] = G + Math.min(DP[i-1][3], DP[i-1][1]);
            DP[i][3] = B + Math.min(DP[i-1][1], DP[i-1][2]);
        }
        System.out.println(Math.min(DP[ordCnt][3],Math.min(DP[ordCnt][1], DP[ordCnt][2])));
    }
}







