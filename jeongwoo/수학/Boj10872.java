import java.util.Scanner;

/**
 * [10872] 팩토리얼
 * https://www.acmicpc.net/problem/10872
 */

public class Boj10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(factorial(n));
    }

    private static int factorial(int x) {
        if (x <= 1) {
            return 1;
        }
        else {
            return x * factorial(x - 1);
        }
    }
}
