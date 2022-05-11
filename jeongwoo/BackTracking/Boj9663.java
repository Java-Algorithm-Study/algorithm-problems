import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [9663] N-Queen
 * https://www.acmicpc.net/problem/9663
 *
 * -아이디어
 * 1. NxN 체스판에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 구해야 한다.
 * 2. 공격할 수 없는 경우는 상하좌우, 대각선으로 이어진 직선상에 다른 퀸이 없어야 한다.
 * 3. i행 arr[i]열에 퀸을 놓기 전에 상하좌우, 대각선을 보면서 놓을 수 있는지를 먼저 체크한다.
 * 4. 놓을 수 있다면 재귀 호출.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj9663 {
    private static int[] arr;
    private static int n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        backTracking(0);
        System.out.println(ans);

    }

    private static void backTracking(int depth) {
        if (depth == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean possible = true;
            for (int j = 0; j < depth; j++) {
                if (!isPossible(depth, i, j, arr[j])) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                arr[depth] = i;
                backTracking(depth + 1);
                arr[depth] = 0;
            }
        }

    }

    private static boolean isPossible(int r1, int c1, int r2, int c2) {
        if (c1 == c2) {
            return false;
        }
        if (r1 - c1 == r2 - c2) {
            return false;
        }
        if (r1 + c1 == r2 + c2) {
            return false;
        }
        return true;
    }

}
