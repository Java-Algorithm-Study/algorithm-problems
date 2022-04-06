import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [6064] 카잉 달력
 * https://www.acmicpc.net/problem/5064
 *
 * -아이디어
 * 1. N과 M보다 작거나 같은 두 자연수 x, y로 해를 나타낸다
 * 2. x % N, y % M으로 표현할 수 있음
 * 3. x, y가 같은 숫자가 될 때까지 years++;
 * 4. 안 나온다면 -1
 * --> 시간 초과
 * 10 12 3 9
 * 1. x에 맞는 years를 구한다.
 * 2. 위 테스트 케이스의 경우 x = 3이니까 가능한 years = 3, 13, 23, ... -> years = Ni + x ( i = 1, 2, 3, ...) years < lcm(N, M)까지
 * 3. 가능한 years에서 y를 구한다. y = years % M
 *
 * -시간 복잡도
 * 1. O(NM)
 * 2. O(lcm(m, n))
 *
 * -자료 구조
 * 1.
 */

public class Boj6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[t][4];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < t; i++) {
                int m = arr[i][0];
                int n = arr[i][1];
                int x = arr[i][2];
                int y = arr[i][3];

                int years = x;
                int max = lcm(m, n);

                while (true) {
                    if (years > max) {
                        System.out.println("-1");
                        break;
                    }
                    else if (((years % n) == 0 ? n : years % n) == y) {
                        System.out.println(years);
                        break;
                    }
                    years += m;
                }
        }


    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);

    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
