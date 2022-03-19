import java.util.Scanner;

/**
 * [1978] 소수 찾기
 * https://www.acmicpc.net/problem/1978
 */


public class Boj1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static boolean isPrime(int x) {
        if (x == 1) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
