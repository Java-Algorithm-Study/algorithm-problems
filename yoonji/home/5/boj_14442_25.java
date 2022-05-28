import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기2
// 벽을 K개 까지 부술 수 있음.
// 1<=N,M<=1000,  1<=K<=10
// 최단거리 출력. 불가능하면 -1
/**
 * K-?개를 부수고 이동한 경로들 / 안부수고 이동한 경로들 중 가장 가까운 최솟값을 구하려면
 * 각각의 방문처리를 따로 해줘야 한다.
 * visited의 길이가 boolean[N][M][K] 어야 한다.
 * 다 부수고 특정 칸에 먼저 도착해도, 이후에 N,M에 도달하지 못하는 경로일 수 있기 때문에!
 * 아예 안부신 경우, K이고 부신 경우 그만큼 K-1
 */
public class boj_14442_25 {
    private static final int WALL = 1;
    private static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    private static int[][] grid;
    private static int N,M;
    private static boolean[][][] visited;
    private static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M][K+1];
        for (int i=0; i<N; i++) {
            String row = br.readLine();
            for (int j=0; j<M; j++) {
                grid[i][j] = row.charAt(j) - '0';
            }
        }
        int minRoute = getMinRoute_bfs();
        System.out.println(minRoute);
    }
    // 목표지점은 N-1, M-1
    private static int getMinRoute_bfs() {
        int minRoute = -1;
        Queue<RouteInfo> que = new LinkedList<>();
        que.add(new RouteInfo(0, 0, K, 1));
        visited[0][0][K] = true;
        while (!que.isEmpty()) {
            RouteInfo curr = que.poll();
            if (curr.col == M-1 && curr.row == N-1) {
                minRoute = curr.moveCnt;
                break;
            }
            for (int i=0; i<4; i++) {
                int nxtRow = curr.row + dir[i][1];
                int nxtCol = curr.col + dir[i][0];
                if (isOutOfBound(nxtRow, nxtCol)) continue;
                if (grid[nxtRow][nxtCol] == WALL) {
                    if (curr.remainCrushCnt>0 && !visited[nxtRow][nxtCol][curr.remainCrushCnt-1]) {
                        visited[nxtRow][nxtCol][curr.remainCrushCnt - 1] = true;
                        que.add(new RouteInfo(nxtRow, nxtCol, curr.remainCrushCnt - 1, curr.moveCnt+1));
                    }
                } else {
                    if (visited[nxtRow][nxtCol][curr.remainCrushCnt]) continue;
                    visited[nxtRow][nxtCol][curr.remainCrushCnt] = true;
                    que.add(new RouteInfo(nxtRow, nxtCol, curr.remainCrushCnt, curr.moveCnt+1));
                }
            }
        }
        return minRoute;
    }
    private static boolean isOutOfBound(int row, int col) {
        return row<0 || row>=N || col <0 || col>=M;
    }
    private static class RouteInfo {
        int row;
        int col;
        int remainCrushCnt;
        int moveCnt;
        RouteInfo(int r, int c, int remainCrushCnt, int moveCnt) {
            this.row = r;
            this.col = c;
            this.remainCrushCnt = remainCrushCnt;
            this.moveCnt = moveCnt;
        }
    }
}