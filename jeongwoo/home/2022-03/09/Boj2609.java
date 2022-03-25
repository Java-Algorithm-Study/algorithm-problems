import java.util.Scanner;

/**
 * [2609] 최대공약수와 최소공배수
 * https://www.acmicpc.net/problem/2609
 */

public class Boj2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));


    }

    public static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x%y);
    }

    public static int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

}
