import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * [17087] 숨바꼭질 6
 * https://www.acmicpc.net/problem/17087
 */

/**
 * -아이디어
 * 1. 수빈이 거리 - 동생들의 각각 거리를 구한다.
 * 2. 1에서 구한 차끼리의 최대 공약수를 구한다.
 *
 * -시간 복잡도
 * 1. for문으로 수빈이 거리 - arr[i] 하니까 O(n) = O(10^5)
 *
 * -자료 구조
 * 1. 수빈이와 동생들의 자리는 최대 10^9 <= 20억이니까 int 사용 가능
 */

public class Boj17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        int[] subtraction = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            subtraction[i] = Math.abs(s - arr[i]);
        }

        int temp = subtraction[0];
        for (int i = 1; i < n; i++) {
            temp = gcd(temp, subtraction[i]);
        }
        System.out.println(temp);

    }

    private static int gcd(int x, int y) {
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }
}
