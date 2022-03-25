import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17103 {
    private static final int N = 1_000_000;
    private static boolean[] prime = new boolean[N + 1];

    public static void makePrime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            for (int k = i * i; k <= N; k += i) {
                if (!prime[i]) {
                    prime[k] = true;
                }
            }
        }
    }

    public static int getNumber(int n) {
        if (n == 4) return 1;
        int count = 0;
        for (int i = 1; i <= n / 2; i += 2) {
            if (!prime[i] && !prime[n - i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int lineNumber = Integer.parseInt(bf.readLine());
        makePrime();

        for (int i = 0; i < lineNumber; i++) {
            int n = Integer.parseInt(bf.readLine());
            System.out.println(getNumber(n));
        }
    }
}
