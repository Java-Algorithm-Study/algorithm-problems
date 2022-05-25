import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽부수고 이동하기
/** 클래스 생성 : 실시간 이동횟수, 이동 위치 row, col, 벽뚫은 여부
 * 부수지 않은 경로가 지나간 경로와 벽을 부순 경로가 지나간 경우를 따로 구분해주어야 한다. 그래야 최솟값을 구할 수 있다고 한다.
 * 부수고 지나간 경로보다 부수지 않고 지나간 경로가 더 빠를 수 있다?
 */
public class boj_2206_23 {
    static final int EMPTY = 0;
    static int N, M;
    static int[][] board;
    static int[] dirX = {0, -1, 0, 1};
    static int[] dirY = {1, 0, -1, 0};
    static boolean[][][] visited; // 벽을 부순 경로가 지나간 경우와 벽을 부수지 않은 경로가 지나간 경우가 중복되어 체크되면 min값을 못구한대. (벽을 부순 경우보다 부수지 않은 경우가 최솟값일 경우가 있다?)
    static int minRoute;
    public static void main(String[] args) throws IOException {
        init();
        getMinRoute_bfs();
        System.out.println(minRoute);
    }
    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = strToInt(st.nextToken());
        M = strToInt(st.nextToken());
        board = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];
        minRoute = N*M+1;
        for (int r=1; r<=N; r++) {
            String line = br.readLine();
            for (int c=1; c<=M; c++) {
                board[r][c] = line.charAt(c-1) - '0';
            }
        }
    }
    private static void getMinRoute_bfs() {
        Queue<MoveInfo> que = new LinkedList<>();
        que.add(new MoveInfo(1, 1, 1, false));
        visited[1][1][0] = true;
        while (!que.isEmpty()) {
            MoveInfo curr = que.poll();
            // N,M 체크
            if (curr.row == N && curr.col == M) {
                minRoute = curr.moveCnt;
                return;
            }
            for (int i=0; i<dirX.length; i++) {
                int nxtR = curr.row + dirY[i];
                int nxtC = curr.col + dirX[i];
                if (isInBound(nxtR, nxtC)) continue;   // 범위

                if (curr.hasWallBreak && !visited[nxtR][nxtC][1]) { // 이전에 벽을 이미 부순 경우 + 부순 경로가 방문안한 칸
                    if (board[nxtR][nxtC] == EMPTY) {
                        visited[nxtR][nxtC][1] = true;
                        que.add(new MoveInfo(nxtR, nxtC, curr.moveCnt + 1, curr.hasWallBreak));
                    }
                } else if (!curr.hasWallBreak && !visited[nxtR][nxtC][0]) { // 부수지 않은 경우 + 부수지 않은 경로가 방문안한 칸
                    // 벽인 경우
                    if (board[nxtR][nxtC] != EMPTY) {
                        visited[nxtR][nxtC][1] = true;
                        que.add(new MoveInfo(nxtR, nxtC, curr.moveCnt + 1, true));
                    } else {
                        visited[nxtR][nxtC][0] = true;
                        que.add(new MoveInfo(nxtR, nxtC, curr.moveCnt + 1, curr.hasWallBreak));
                    }
                }
            }
        }
        minRoute = -1;
    }

    private static boolean isInBound(int nxtR, int nxtC) {
        return nxtR<1 || nxtR > N || nxtC<1 || nxtC > M;
    }
    private static int strToInt(String str) { return Integer.parseInt(str); }
    private static class MoveInfo {
        int row;
        int col;
        int moveCnt;
        boolean hasWallBreak;
        MoveInfo (int row, int col, int moveCnt, boolean hasWallBreak) {
            this.row = row;
            this.col = col;
            this.moveCnt = moveCnt;
            this.hasWallBreak = hasWallBreak;
        }
    }
}