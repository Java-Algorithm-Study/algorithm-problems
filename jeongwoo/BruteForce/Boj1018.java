import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [1018] 체스판 다시 칠하기
 * https://www.acmicpc.net/problem/1018
 *
 * -아이디어
 * 1. 입력으로 받은 board를 (0, 0) ~ (n, m)까지 8*8로 잘라서 탐색한다.
 * 2. 처음 색깔 순서대로 가면 변경해야 되는 횟수(cnt)와 처음 색깔과 반대 순서로 이어지면 변경해야 되는 횟수(64 - cnt)를 구한다.
 *
 */

public class Boj1018 {
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = input[j];
            }
        }


        // 0,0부터 n,m까지 8*8을 다 검사 시작 (len - 8 + 1까지만 탐색하면 됨.) -> 8개씩 봐야 되니까
        for (int i = 0; i < n - 8 + 1; i++) {
            for (int j = 0; j < m - 8 + 1; j++) {
                find(i, j, board);
            }
        }

        System.out.println(min);

    }

    private static void find(int x, int y, char[][] board) {
        int change = 0;
        char now = board[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (board[i][j] != now) {
                    change++;
                }
                if (now == 'B') {
                    now = 'W';
                }
                else {
                    now = 'B';
                }
            }

            if (now == 'B') {
                now = 'W';
            }
            else {
                now = 'B';
            }
        }

        // 첫 글자 색깔 순서대로 변경한 횟수 change와 첫 글자와 반대의 색깔 순서로 변경한 횟수 64-count
        change = Math.min(change, 64 - change);

        min = Math.min(min, change);

    }
}
