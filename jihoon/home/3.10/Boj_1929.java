import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1929 {
    private static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean[] makePrime(int n) {
        var primes = new boolean[n + 1];
        primes[0] = primes[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        var sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] primes = makePrime(b);

        // a와 b사이 모든 정수를 소수인지 확인하는 방법: 18584KB / 496ms
//        for (int i = a; i <= b; i++) {
//            if (isPrime(i)) sb.append(i).append('\n');
//        }

        // 에라토스테네스의 체를 이용하는 방법: 20144KB / 232ms
        for (int i = a; i <= b; i++) {
            if (!primes[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}
