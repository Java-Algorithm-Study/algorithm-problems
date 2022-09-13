import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [6588] 골드바흐의 추측
 * https://www.acmicpc.net/problem/6588
 */

public class Boj6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        int n = -1;
        boolean flag = false;
        while (n != 0) {
            str = br.readLine();
            n = Integer.parseInt(str);
            for (int i = 3; i <= n/2; i = i + 2) {
                if (isPrime(i)) {
                    int a = n - i;
                    if (isPrime(a)) {
                        System.out.println(n + " = " + i + " + " + a);
                        flag = true;
                        break;
                    }

                }
            }

            if (!flag)
                System.out.println("Goldbach's conjecture is wrong.");
        }

    }

    private static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}
