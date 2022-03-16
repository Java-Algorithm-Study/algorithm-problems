import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [11653] 소인수분해
 * https://www.acmicpc.net/problem/11653
 *
 * -아이디어
 * 1. 정수 N을 i를 나누는데, 나머지가 0이 될 때마다 i를 출력한다.
 *
 * -시간 복잡도
 * 1. O(N), N < 10,000,000
 */

public class Boj11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                sb.append(i).append('\n');
                n /= i;
            }
        }
        System.out.println(sb.toString());
    }
}
