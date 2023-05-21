package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1309 {
    static long DP [];
    static final int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        DP = new long[N+1];
        DP[0] = 1;
        DP[1] = 3;
        for (int i = 2; i < DP.length; i++) {
            long a = DP[i-1];
            long b = DP[i-2];
            DP[i] = (a * 2 + b) % MOD;
        }

        System.out.println(DP[N]);
    }
}