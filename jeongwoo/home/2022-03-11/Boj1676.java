import java.util.Scanner;

/**
 * [1676] 팩토리얼 0의 개수
 * https://www.acmicpc.net/problem/1676
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;

        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }

        System.out.println(cnt);
    }
}
