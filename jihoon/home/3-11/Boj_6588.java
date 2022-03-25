import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_6588 {
    private static final int N = 1000000;
    private static boolean[] primes = new boolean[N + 1];

    public static void makePrimeNumber(int n) {
        primes[0] = primes[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= n ; j += i) {
                    primes[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        makePrimeNumber(N);
        var bf = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!(line = bf.readLine()).equals("0")) {
            var sb = new StringBuffer();
            int n = Integer.parseInt(line);
            for (int a = 3; a <= n - 3; a += 2) {
                int b = n - a;
                if (!primes[a] && !primes[b]) {
                    sb.append(n).append(" = ").append(a).append(" + ").append(b);
                    break;
                }
            }
            if (sb.length() == 0) System.out.println("Goldbach's conjecture is wrong.");
            else {
                System.out.println(sb);
                sb.setLength(0);
            }
        }
        bf.close();
    }
}