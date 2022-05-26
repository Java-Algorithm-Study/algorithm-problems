import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽부수고 이동하기
/** 클래스 생성 : 실시간 이동횟수, 이동 위치 row, col, 벽뚫은 여부
 * 부수지 않은 경로가 지나간 경로와 벽을 부순 경로가 지나간 경우를 따로 구분해주어야 한다. 그래야 끝까지 도달할 때까지의 최솟값을 구할 수 있다.
 * 현재 지점까지 도달하는데에 부수고 지나간 경로보다 부수지 않고 지나간 경로가 더 빠르거나 끝까지 도달할 수 있다!
 *
 * 나의 기존 풀이는 아래의 경우를 고려하지 못했었다. (참고: https://www.acmicpc.net/board/view/27386)
 * 벽을 안 부수고도 현재 칸까지 도달이 가능하지만, 벽을 부수고 오는 것이 더 짧다고 가정한다.
 * 현재 지점에서 목표 지점까지 가려면 무조건 벽을 한 개 부숴야만 된다. 비록 현재 칸까지는 벽을 부수고 오는 것이 최적이었지만, 이 상태로는 끝에 아예 도달을 못 한다.
 * 현재 칸까지는 더 멀더라도 벽을 안 부수고 와야, 끝에 도달이 가능하다면?
 * => 그래서 현재 칸까지 부수고 도달한 경우와 부수지 않고 도달한 경우를 모두 고려해주어 N,M까지 도착해야 제대로된 최솟값을 구할 수 있다.
 *
 * 또한, 다른 풀이글에서 많이 본 방법이 있는데, 아래와 같은 원리에 의한 것이다.
 * 같은 칸에 방문하는 경우 벽을 안 부순 것이 더 유리하기 때문에 벽을 부쉈는지 여부를 방문 배열에 기록하여 부순 횟수가 더 적을 때만 방문하는 방법도 된다.
 * 그러나 이는 문제의 특성 때문에 이 문제에서만 통하는 그리디이므로 다른 문제에도 함부로 사용해서는 안된다.
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