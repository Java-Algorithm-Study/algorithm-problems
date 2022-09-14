import java.util.Scanner;

/**
 * [1929] 소수 구하기
 * https://www.acmicpc.net/problem/1929
 */

public class Boj1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        else {
            for (int i = 2; i*i <= x; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
