import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 구슬탈출2
public class boj_13460_14 {
    private static class MoveInfo {
        int redR;
        int redC;
        int blueR;
        int blueC;
        int moveCnt;
        MoveInfo(int redR, int redC, int blueR, int blueC, int moveCnt) {
            this.redR = redR;
            this.redC = redC;
            this.blueR = blueR;
            this.blueC = blueC;
            this.moveCnt = moveCnt;
        }
    }
    static final char WALL = '#';
    static final char HOLE = 'O';
    static char[][] board;
    static int minMove = -1;
    static int[] dirR = {-1, 0, 1, 0};
    static int[] dirC = {0, 1, 0, -1};
    static boolean[][][][] visited;
    static Queue<MoveInfo> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        initAndCallBfs();
        System.out.println(minMove);
    }
    private static void initAndCallBfs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        int Rr = 0;
        int Rc = 0;
        int Br = 0;
        int Bc = 0;
        for (int r=0; r<N; r++) {
            String line = br.readLine();
            for (int c=0; c<M; c++) {
                board[r][c] = line.charAt(c);
                if (board[r][c] == 'R') {
                    Rr = r; Rc = c;
                }
                if (board[r][c] == 'B') {
                    Br = r; Bc = c;
                }
            }
        }
        que.offer(new MoveInfo(Rr, Rc, Br, Bc, 0));
        visited[Rr][Rc][Br][Bc] = true;
        bfs();
    }
    private static void bfs() {
        boolean isRedPass;
        boolean isBluePass;
        while (!que.isEmpty()) {
            MoveInfo now = que.poll();
            if (now.moveCnt == 10) {
                minMove = -1;
                return;
            }
            for (int i = 0; i < dirR.length; i++) {
                int nxtRr = now.redR;
                int nxtRc = now.redC;
                int nxtBr = now.blueR;
                int nxtBc = now.blueC;
                isRedPass = false;
                isBluePass = false;
                // red 이동
                while (board[nxtRr + dirR[i]][nxtRc + dirC[i]] != WALL) {
                    nxtRr += dirR[i];
                    nxtRc += dirC[i];
                    if (board[nxtRr][nxtRc] == HOLE) {
                        isRedPass = true;
                        break;
                    }
                }
                // blue 이동
                while (board[nxtBr + dirR[i]][nxtBc + dirC[i]] != WALL) {
                    nxtBr += dirR[i];
                    nxtBc += dirC[i];
                    if (board[nxtBr][nxtBc] == HOLE) {
                        isBluePass = true;
                        break;
                    }
                }
                if (isBluePass) continue;
                if (isRedPass) {
                    minMove = now.moveCnt + 1;
                    return;
                }
                // 구슬이 같은 위치에 있고 빨간 구슬이 통과된게 아니면 구슬 한개 옮기기
                // 빨간 구슬이 통과됐으면 옮길필요 x
                if (nxtRr == nxtBr && nxtRc == nxtBc) {
                    switch (i) {
                        case 0:
                            if (now.redR > now.blueR) nxtRr -= dirR[i];
                            else nxtBr -= dirR[i];
                            break;
                        case 1:
                            if (now.redC < now.blueC) nxtRc -= dirC[i];
                            else nxtBc -= dirC[i];
                            break;
                        case 2:
                            if (now.redR < now.blueR) nxtRr -= dirR[i];
                            else nxtBr -= dirR[i];
                            break;
                        case 3:
                            if (now.redC > now.blueC) nxtRc -= dirC[i];
                            else nxtBc -= dirC[i];
                            break;
                    }
                }
                // 다음 기울임 ㄱㄱ
                if (visited[nxtRr][nxtRc][nxtBr][nxtBc]) continue;
                visited[nxtRr][nxtRc][nxtBr][nxtBc] = true;
                que.offer(new MoveInfo(nxtRr, nxtRc, nxtBr, nxtBc, now.moveCnt+1));
            }
        }
    }

    private static void dfs (int Rr, int Rc, int Br, int Bc, int move) {
        if (move == 11) return;             // 구멍에 못들어갔으니 pass
        if (board[Br][Bc] == HOLE) return;  // 파란구슬 구멍에 들어갔으니 pass
        if (board[Rr][Rc] == HOLE) {
            minMove = Math.min(minMove, move);
            return;
        }
        visited[Rr][Rc][Br][Bc] = true;
        for (int i=0; i<dirR.length; i++) {
            int nextRr = Rr;
            int nextRc = Rc;
            int nextBr = Br;
            int nextBc = Bc;
            // 한방향으로 끝까지 갈 수 있을 동안 while문 (red는 HOLE이거나 WALL 만날때까지 이동 O)
            // red 이동
            while (board[nextRr + dirR[i]][nextRc + dirC[i]] != WALL) {
                nextRr += dirR[i];
                nextRc += dirC[i];
                if (board[nextRr][nextRc] == HOLE) break;
            }
            // blue 이동
            while (board[nextBr + dirR[i]][nextBc + dirC[i]] != WALL) {
                nextBr += dirR[i];
                nextBc += dirC[i];
                if (board[nextBr][nextBc] == HOLE) break;
            }
            // 구슬이 같은 위치에 있고 빨간 구슬이 통과된게 아니면 구슬 한개 옮기기
            // 빨간 구슬이 통과됐으면 옮길필요 x
            if (nextRr == nextBr && nextRc == nextBc && board[nextRr][nextRc] != HOLE) {
                switch (i) {
                    case 0:
                        if (Rr > Br) nextRr--;
                        else nextBr--;
                        break;
                    case 1:
                        if (Rr > Br) nextRr++;
                        else nextBr++;
                        break;
                    case 2:
                        if (Rc > Bc) nextBc--;
                        else nextRc--;
                        break;
                    case 3:
                        if (Rc > Bc) nextRc++;
                        else nextBc++;
                }
            }
            // 다음 기울임 ㄱㄱ
            if(visited[nextRr][nextRc][nextBr][nextBc]) continue;
            dfs(nextRr, nextRc, nextBr, nextBc, move + 1);
        }
        visited[Rr][Rc][Br][Bc] = false;
    }
}