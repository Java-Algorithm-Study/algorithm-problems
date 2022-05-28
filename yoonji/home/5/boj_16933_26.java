import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽부수고 이동하기 3
// 한칸 이동 or 머무를 때 마다 낮-밤이 바뀐다.
// 인접 4칸 이동
// 조건
// 0. 현재 K 상태에 방문한적 있는지 체크 (이미 방문했다면 최솟값이 될 수 없으므로 pass)
// 1. 벽 vs 빈 칸 체크
// 2. 낮 vs 밤 체크   (낮에만 벽 부수기 가능)
// 3. 부술 수 있는지 체크  (K개까지 벽 부수기 가능)
public class boj_16933_26 {
    private static final int WALL = 1;
    private static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    private static int N,M,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];
        for (int i=0; i<N; i++) {
            String row = br.readLine();
            for (int j=0; j<M; j++) {
                grid[i][j] = row.charAt(j) - '0';
            }
        }
        System.out.println(getMinRoute_bfs(grid));
    }
    private static int getMinRoute_bfs(int[][] grid) {
        boolean[][][] visited = new boolean[N][M][K+1];
        Queue<RouteInfo> que = new LinkedList<>();
        que.add(new RouteInfo(0, 0, 1, K, true));
        visited[0][0][K] = true;
        while (!que.isEmpty()) {
            RouteInfo curr = que.poll();
            // 중지 조건
            if (curr.row == N-1 && curr.col == M-1) {
                return curr.moveCnt;
            }
            for (int i=0; i<4; i++) {
                int nxtRow = curr.row + dir[i][1];
                int nxtCol = curr.col + dir[i][0];
                if (isOutOfBound(nxtRow, nxtCol)) continue;
                if (grid[nxtRow][nxtCol] == WALL) {
                    if (curr.remainCrushCnt <=0 ) continue;
                    if (visited[nxtRow][nxtCol][curr.remainCrushCnt-1]) continue;
                    visited[nxtRow][nxtCol][curr.remainCrushCnt-1] = true;
                    if (curr.isAfternoon)    //낮이면
                        que.add(new RouteInfo(nxtRow, nxtCol, curr.moveCnt + 1, curr.remainCrushCnt - 1, false));
                    else    // 밤이면 낮 되기까지 기다리고 뚫면 되니까 +2
                        que.add(new RouteInfo(nxtRow, nxtCol, curr.moveCnt + 2, curr.remainCrushCnt - 1, true));

                } else {
                    if (visited[nxtRow][nxtCol][curr.remainCrushCnt]) continue;
                    visited[nxtRow][nxtCol][curr.remainCrushCnt] = true;
                    que.add(new RouteInfo(nxtRow, nxtCol, curr.moveCnt + 1, curr.remainCrushCnt, !curr.isAfternoon));
                }
            }
        }
        return -1;
    }
    private static boolean isOutOfBound(int row, int col) {
        return row<0 || row>=N || col <0 || col>=M;
    }
    /**
     * 경로를 거치는데 가지고 다녀야할 정보들을 갖는 클래스
     */
    private static class RouteInfo {
        int row;
        int col;
        int moveCnt;
        int remainCrushCnt;
        boolean isAfternoon;
        RouteInfo (int r, int c, int moveCnt, int remainCrushCnt, boolean isAfternoon) {
            this.row = r;
            this.col = c;
            this.moveCnt = moveCnt;
            this.remainCrushCnt = remainCrushCnt;
            this.isAfternoon = isAfternoon;
        }
    }
}