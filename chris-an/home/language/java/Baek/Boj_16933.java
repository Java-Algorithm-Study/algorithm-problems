package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
    이동하지 않고 같은 칸에 머물러 있는 경우도 가능하다.
    이 경우도 방문한 칸의 개수가 하나 늘어나는 것으로 생각해야 한다.

    이번 문제에서는 낮과 밤이 번갈아가면서 등장한다.
    가장 처음에 이동할 때는 낮이고,
    한 번 이동할 때마다 낮과 밤이 바뀌게 된다.
    이동하지 않고 같은 칸에 머무르는 경우에도 낮과 밤이 바뀌게 된다.

    만약에 이동하는 도중에
    벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면,
    벽을 K개 까지 부수고 이동하여도 된다.

    단, 벽은 낮에만 부술 수 있다.
 */

public class Boj_16933 {
    static int N, M, K;
    static char[][] board;
    static boolean[][][][] visited;
    static final int fourDirection = 4;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    static class wallLocAndStatus {
        int x;
        int y;
        int movedCnt;
        int crashCntCheck;
        int dayOrNight;

        public wallLocAndStatus(int x, int y, int movedCnt, int crashCntCheck, int dayOrNight) {
            this.x = x;
            this.y = y;
            this.movedCnt = movedCnt;
            this.crashCntCheck = crashCntCheck;
            this.dayOrNight = dayOrNight;
        }
    }

    static boolean bfs() {
        Queue<wallLocAndStatus> qu = new LinkedList<>();
        visited[0][0][0][0] = true;
        qu.offer(new wallLocAndStatus(0, 0, 1, 0, 0));

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
                    if (point.crashCntCheck >= K) continue;
                    else {
                        // 밤이니? 그럼 낮이 될 때까지 기다리기.
                        if (point.dayOrNight == 1) {
                            if (visited[point.crashCntCheck + 1][nx][ny][1]) continue;
                            visited[point.crashCntCheck + 1][nx][ny][1] = true;
                            qu.offer(new wallLocAndStatus(point.x, point.y, point.movedCnt + 1, point.crashCntCheck, 0));
                            // 낮이니?
                        }else {
                            if (visited[point.crashCntCheck + 1][nx][ny][0]) continue;

                            visited[point.crashCntCheck + 1][nx][ny][0] = true;
                            qu.offer(new wallLocAndStatus(nx, ny, point.movedCnt + 1, point.crashCntCheck + 1, 1));
                        }
                    }
                    //벽을 안 만났니?
                }else {
                    int dayOrNightCheck = point.dayOrNight == 1 ? 0 : 1;
                    if (visited[point.crashCntCheck][nx][ny][dayOrNightCheck]) continue;

                    visited[point.crashCntCheck][nx][ny][dayOrNightCheck] = true;
                    qu.offer(new wallLocAndStatus(nx, ny, point.movedCnt + 1, point.crashCntCheck, dayOrNightCheck));
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
        visited = new boolean[K + 1][N][M][2];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        if (bfs()) System.out.println(min);
        else System.out.println(-1);
    }
}
