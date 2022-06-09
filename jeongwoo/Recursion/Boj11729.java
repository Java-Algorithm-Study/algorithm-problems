import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [11729] 하노이 탑 이동 순서
 * https://www.acmicpc.net/problem/11729
 *
 * -아이디어
 * 1. 1에 있는 n-1개를 2(목적지가 아닌 기둥)으로 보낸다.
 * 2. 1에 있는 마지막 판을 3(목적지)로 보낸다.
 * 3. 2에 있는 N-1개를 3(목적지)로 보낸다.
 * 4. 판이 1개가 남으면 3(목적지)로 보내고 재귀는 끝난다.
 *
 */

public class Boj11729 {
    private static int cnt;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3, 2);
        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int to, int by) {
        if (n == 1) {
            move(from, to);
            return;
        }
        hanoi(n-1, from, by, to);
        move(from, to);
        hanoi(n-1, by, to, from);
    }

    private static void move(int from, int to) {
        sb.append(from).append(' ').append(to).append('\n');
        cnt++;
    }
}
