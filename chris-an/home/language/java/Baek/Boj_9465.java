package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9465 {
    static long DP [][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long arr [][] = new long[2][N+1];
            DP = new long[2][N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[0][i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[1][i] = Integer.parseInt(st.nextToken());

            DP[0][0] = arr[0][0];
            DP[1][0] = arr[1][0];

            for (int i = 1; i < N; i++) {
                DP[0][i] = DP[1][i-1] + arr[0][i];
                DP[1][i] = DP[0][i-1] + arr[1][i];
                if (i > 1) {
                    DP[0][i] = Math.max(DP[1][i-2] + arr[0][i], DP[0][i]);
                    DP[1][i] = Math.max(DP[0][i-2] + arr[1][i], DP[1][i]);
                }
            }
            System.out.println(Math.max(DP[0][N-1], DP[1][N-1]));
        }
    }
}

