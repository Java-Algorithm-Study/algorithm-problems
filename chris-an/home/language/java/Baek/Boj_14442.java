package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14442 {
    static int N, M, K;
    static char[][] board;
    static boolean[][][] visited;
    static final int fourDirection = 4;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    static class wallLocAndStatus {
        int x;
        int y;
        int movedCnt;
        int crashCntCheck;

        public wallLocAndStatus(int x, int y, int movedCnt, int crashCntCheck) {
            this.x = x;
            this.y = y;
            this.movedCnt = movedCnt;
            this.crashCntCheck = crashCntCheck;
        }
    }

    static boolean bfs() {
        Queue<wallLocAndStatus> qu = new LinkedList<>();
        visited[0][0][0] = true;
        qu.offer(new wallLocAndStatus(0, 0, 1, 0));

        while (!qu.isEmpty()) {
            wallLocAndStatus point = qu.poll();

            if (point.x == N-1 && point.y == M-1) {
                min = point.movedCnt;
                return true;
            }

            for (int i = 0; i < fourDirection; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                //벽을 만났니?
                if (board[nx][ny] == '1') {
                    // 벽을 만났는데, 벽을 못부셔? pass
                    if (point.crashCntCheck >= K) continue;
                    else {
                        // 벽을 부실 수 있어?
                        if (visited[point.crashCntCheck + 1][nx][ny]) continue;

                        visited[point.crashCntCheck + 1][nx][ny] = true;
                        qu.offer(new wallLocAndStatus(nx, ny, point.movedCnt + 1, point.crashCntCheck + 1));
                    }

                    //벽을 안 만났니?
                }else {
                    if (visited[point.crashCntCheck][nx][ny]) continue;

                    visited[point.crashCntCheck][nx][ny] = true;
                    qu.offer(new wallLocAndStatus(nx, ny, point.movedCnt + 1, point.crashCntCheck));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[K + 1][N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        if (bfs()) System.out.println(min);
        else System.out.println(-1);
    }
}
