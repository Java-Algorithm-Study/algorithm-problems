import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * [2407] 조합
 * https://www.acmicpc.net/problem/2407
 *
 * -아이디어
 * 1. nCm 출력해야 한다.
 * 2. nCm => n! / ((n-m)! * m!)
 *
 */

public class Boj2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(combination(n, m));

    }

    private static BigInteger combination(int n, int m) {
        BigInteger num1 = BigInteger.ONE;
        BigInteger num2 = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            num1 = num1.multiply(new BigInteger(String.valueOf(n - i)));
            num2 = num2.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        return num1.divide(num2);
    }
}
