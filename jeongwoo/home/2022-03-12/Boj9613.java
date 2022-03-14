import java.util.Scanner;

/**
 * [9613] GCD 합
 * https://www.acmicpc.net/problem/9613
 */

/**
 * -아이디어
 * 1. for를 돌면서 arr[k], arr[k+1]의 최대공약수를 구한다.
 * 2. 구한 최대공약수를 sum에 더한다.
 *
 * -시간 복잡도
 * 1. O(n^2)
 *
 * -자료 구조
 * 1. 입력으로 주어지는 숫자가 1,000,000인데, 테스트 케이스는 100개 이하로 들어온다.
 * 2. 최대로 생각했을 때 sum에 더해지는 숫자가 20억을 넘어갈 수 있으니 long으로 한다.
 */

public class Boj9613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n  = sc.nextInt();
            int[] arr = new int[n];
            long sum = 0;

            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            for (int k = 0; k < n; k++) {
                for (int l = k+1; l < n; l++) {
                    sum += gcd(arr[k], arr[l]);
                }
            }
            System.out.println(sum);
        }
    }

    private static int gcd(int x, int y) {
        if (y == 0)
            return x;
        else
            return gcd(y, x%y);
    }
}
