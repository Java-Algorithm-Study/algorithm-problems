package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11057 {
    static long DP[][];
    static final int MOD = 10_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        DP = new long[N+1][10]; //0~10
        Arrays.fill(DP[0], 1);
        for (int i = 1; i < DP.length; i++) {
            DP[i][0] = 1;
        }

        for (int i = 1; i < DP.length; i++) {
            for (int j = 1; j< DP[i].length; j++) {
                DP[i][j] = (DP[i][j-1] + DP[i-1][j]) % MOD;
            }
        }
        System.out.println(DP[N][9]);
    }
}





