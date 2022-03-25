import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_6588_enhanced {
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

    public static String sumOfPrimes(boolean[] primes, int n) {
        for (int i = n - 1; i >= n / 2; i--) {
            if (!primes[i]) {
                for (int j = 0; j <= n / 2; j++) {
                    if (!primes[j] && i + j == n) {
                        int min = j;
                        int max = i;
                        return String.valueOf(min) + " + " + String.valueOf(max);
                    }
                }
            }
        }
        return "Goldbach's conjecture is wrong.";
    }

    public static void main(String[] args) throws IOException {
        makePrimeNumber(N);
        var bf = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!(line = bf.readLine()).equals("0")) {
            int n = Integer.parseInt(line);
            System.out.println(String.valueOf(n) + " = " + sumOfPrimes(primes, n));
        }
        bf.close();
    }
}