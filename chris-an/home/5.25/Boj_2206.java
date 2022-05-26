import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206 {

    static int N, M;
    static char[][] board;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;
    static final int fourDirection = 4;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class WallLocAndStatus {
        int x;
        int y;
        int movedCnt;
        int crashCheck;

        public WallLocAndStatus(int x, int y, int movedCnt, int crashCheck) {
            this.x = x;
            this.y = y;
            this.movedCnt = movedCnt;
            this.crashCheck = crashCheck;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[2][N][M];
        for (int i = 0 ; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        if (bfs()) System.out.println(min);
        else System.out.println(-1);
    }

    private static boolean bfs() {
        Queue<WallLocAndStatus> qu = new LinkedList<>();
        visited[0][0][0] = true;
        qu.offer(new WallLocAndStatus(0, 0, 1, 0));

        while (!qu.isEmpty()) {
            WallLocAndStatus point = qu.poll();

            if (point.x == N-1 && point.y == M-1) {
                min = point.movedCnt;
                return true;
            }
            for (int i = 0; i < fourDirection; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 옮긴 위치가 벽이 있다.
                if (board[nx][ny] == '1') {
                    // 벽을 부순 적이 있다.
                    if (point.crashCheck == 1) continue;
                        // 벽을 부순 적이 없다.
                    else {
                        if (visited[1][nx][ny]) continue;

                        visited[1][nx][ny] = true;
                        qu.offer(new WallLocAndStatus(nx, ny, point.movedCnt + 1, 1));
                    }
                    // 옮긴 위치가 벽이 없다. (벽을 부쉈고 안 부쉈고 double Checking)
                }else {
                    if (visited[point.crashCheck][nx][ny]) continue;

                    visited[point.crashCheck][nx][ny] = true;
                    qu.offer(new WallLocAndStatus(nx, ny, point.movedCnt + 1, point.crashCheck));
                }
            }
        }
        return false;
    }
}
