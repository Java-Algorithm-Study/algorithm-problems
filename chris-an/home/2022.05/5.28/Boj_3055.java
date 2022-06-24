import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3055 {
    static int R, C;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서
    static int[] dy = {0, 1, 0, -1};
    static Queue<hedgehogLoc> qu = new LinkedList<>();
    static final int fourDirection = 4;

    private static class hedgehogLoc {
        int x;
        int y;
        int movedCnt;

        public hedgehogLoc(int x, int y, int movedCnt) {
            this.x = x;
            this.y = y;
            this.movedCnt = movedCnt;
        }
    }

    private static String bfs() {
        boolean[][] visited = new boolean[R][C];
        while (!qu.isEmpty()) {
            //visited = new boolean[R][C];
            int movedInMinuteCnt = qu.size();

            for (int i = 0; i < movedInMinuteCnt; i++) {
                hedgehogLoc point = qu.poll();
                visited[point.x][point.y] = true;

                if (board[point.x][point.y] == 'D') return String.valueOf(point.movedCnt);
                if (board[point.x][point.y] == '*') continue;

                for (int d = 0; d < fourDirection; d++) {
                    int nx = point.x + dx[d];
                    int ny = point.y + dy[d];

                    if (!isPossibleRange(nx, ny)) continue;
                    if (visited[nx][ny] || board[nx][ny] == 'X' || board[nx][ny] == '*') continue;

                    visited[nx][ny] = true;
                    qu.add(new hedgehogLoc(nx, ny, point.movedCnt + 1));
                }
            }
            floodedWithWater();
        }
        return "KAKTUS";
    }

    private static void floodedWithWater() {
        Queue<Integer> waterLoc = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '*') {
                    waterLoc.offer(i);
                    waterLoc.offer(j);
                }
            }
        }

        while (!waterLoc.isEmpty()) {
            int wX = waterLoc.poll();
            int wY = waterLoc.poll();

            for (int i = 0; i < fourDirection; i++) {
                int nx = wX + dx[i];
                int ny = wY + dy[i];

                if (!isPossibleRange(nx, ny)) continue;
                if (board[nx][ny] == '*') continue;
                if (board[nx][ny] == 'D') continue;
                if (board[nx][ny] == 'X') continue;

                board[nx][ny] = '*';
            }
        }
    }

    private static boolean isPossibleRange(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'S') qu.offer(new hedgehogLoc(i, j, 0));
            }
        }
        System.out.println(bfs());
    }
}
