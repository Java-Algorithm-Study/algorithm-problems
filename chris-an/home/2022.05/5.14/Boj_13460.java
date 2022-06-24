import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13460 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static final int fourDirection = 4;
    private static int N, M; // 세로(row), 가로(column)
    private static char[][] board;
    private static Queue<Bead> qu = new LinkedList<>();
    private static boolean[][][][] visited;
    private static int min = -1;

    private static class Bead {
        int redX;
        int redY;
        int blueX;
        int blueY;
        int cnt;

        public Bead(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }

    private static void bfs() {
        while (!qu.isEmpty()) {
            Bead bead = qu.poll();

            if (bead.cnt == 10) {
                min = -1;
                return;
            }

            for (int i = 0; i < fourDirection; i++) {
                int red_nx = bead.redX;
                int red_ny = bead.redY;
                int blue_nx = bead.blueX;
                int blue_ny = bead.blueY;

                //checking a bead falls into a hole
                boolean redBead = false;
                boolean blueBead = false;


                while (board[red_nx + dx[i]][red_ny + dy[i]] != '#') {
                    red_nx += dx[i];
                    red_ny += dy[i];
                    if (board[red_nx][red_ny] == 'O') {
                        redBead = true;
                        break;
                    }
                }

                while (board[blue_nx + dx[i]][blue_ny + dy[i]] != '#') {
                    blue_nx += dx[i];
                    blue_ny += dy[i];
                    if (board[blue_nx][blue_ny] == 'O') {
                        blueBead = true;
                        break;
                    }
                }

                if (blueBead) continue;
                if (redBead || blueBead) {
                    min = bead.cnt + 1;
                    return;
                }

                // 기울렸을 때, 구슬이 동일 위치에 있을 경우, 구슬 조정
                if (red_nx == blue_nx && red_ny == blue_ny) {
                    switch (i) {
                        // 북쪽
                        case 0 :
                            if(bead.redX > bead.blueX) red_nx -= dx[i];
                            else blue_nx -= dx[i]; // 위치조정
                            break;
                        case 1 :
                            if (bead.redY < bead.blueY) red_ny -= dy[i];
                            else blue_ny -= dy[i]; // 위치조정
                            break;
                        case 2 :
                            if(bead.redX < bead.blueX) red_nx -= dx[i];
                            else blue_nx -= dx[i]; // 위치조정
                            break;
                        case 3 :
                            if (bead.redY > bead.blueY) red_ny -= dy[i];
                            else blue_ny -= dy[i]; // 위치조정
                            break;
                    }
                }
                if (!visited[red_nx][red_ny][blue_nx][blue_ny]) {
                    visited[red_nx][red_ny][blue_nx][blue_ny] = true;
                    qu.offer(new Bead(red_nx, red_ny, blue_nx, blue_ny, bead.cnt + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        int rx = 0, ry = 0, bx = 0, by =  0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }else if(board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        visited[rx][ry][bx][by] = true;
        qu.offer(new Bead(rx, ry, bx, by, 0));
        bfs();
        System.out.println(min);
    }
}
