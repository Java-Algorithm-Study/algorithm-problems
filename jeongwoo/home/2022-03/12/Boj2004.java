import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [2004] 조합 0의 개수
 * https://www.acmicpc.net/problem/2004
 *
 * -아이디어
 * 1. 조합 공식: nCr = n! / r! * (n-r)!
 * 2. n < 2,000,000,000이어서 주어진 입력값의 팩토리얼을 구하는 것은 어렵다.
 * 3. 0의 개수이므로 0은 2*5가 있어야 0이 생기니까 각 수의 2, 5가 몇 개 들어있는지 구하면 된다.
 *
 * -시간 복잡도
 * 1. O(N) 이하
 */

public class Boj2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int twoCnt = findTwo(n) - findTwo(m) - findTwo(n - m);
        int fiveCnt = findFive(n) - findFive(m) - findFive(n - m);

        System.out.println(Math.min(twoCnt, fiveCnt));
    }

    private static int findTwo(int x) {
        int cnt = 0;

        while (x >= 2) {
            cnt += x / 2;
            x /= 2;
        }

        return cnt;
    }

    private static int findFive(int x) {
        int cnt = 0;

        while (x >= 5) {
            cnt += x / 5;
            x /= 5;
        }

        return cnt;
    }
}
