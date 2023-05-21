package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987 {
    private static int row, column;
    private static char[][] board;
    private static boolean[] visited = new boolean[26]; // 알파벳 수만큼
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static final int fourDirection = 4;
    private static int max = Integer.MIN_VALUE;

    public static void dfs(int r, int c, int count) {
        max = Math.max(max, count);
        // recur
        for (int i = 0; i < fourDirection; i++) {
            int movedRow = r + dx[i];
            int movedColumn = c + dy[i];
            if (movedRow < 0 || movedColumn < 0 || movedRow >= row || movedColumn >= column) continue;
            int moveHorse = board[movedRow][movedColumn] - 65;
            if (!visited[moveHorse]) {
                visited[moveHorse] = true;
                dfs(movedRow, movedColumn, count + 1);
                visited[moveHorse] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // R과 C 값 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        board = new char[row][column];

        for (int i = 0; i < row; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < column; j++) {
                board[i][j] = line[j];
            }
        }
        visited[board[0][0] - 65] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }
}
