import java.util.Scanner;

/**
 * [1934] 최소공배수
 * https://www.acmicpc.net/problem/1934
 */

public class Boj1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(lcm(a, b));
        }
    }

    public static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x%y);
    }

    public static int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

}
