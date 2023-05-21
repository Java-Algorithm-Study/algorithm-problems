package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long divide5 = divide(N, 5);
        long divide2 = divide(N, 2);

        divide5 -= divide(M, 5);
        divide5 -= divide(N - M, 5);

        divide2 -= divide(M, 2);
        divide2 -= divide(N - M, 2);

        System.out.println(Math.min(divide5, divide2));
    }

    public static int divide(long N, long d) {
        int res = 0;
        for (long i = d; i <= N; i *= d) {
            res += N / i;
        }
        return res;
    }
}