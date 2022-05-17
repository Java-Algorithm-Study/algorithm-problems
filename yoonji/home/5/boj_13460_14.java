import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 구슬탈출2
public class boj_13460_14 {
    static final char WALL = '#';
    static final char HOLE = 'O';
    static char[][] board;
    static int minMove = 11;
    static int[] dirR = {1,-1,0,0};
    static int[] dirC = {0,0,1,-1};
    static boolean[][][][] visited;
    public static void main(String[] args) throws IOException {
        initAndCallDfs();
        System.out.println(minMove==11?-1:minMove);
    }
    private static void initAndCallDfs() throws IOException {
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
        // 2. 경우의 수 돌며 최소의 move 구하기
        dfs(Rr, Rc, Br, Bc, 0);
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