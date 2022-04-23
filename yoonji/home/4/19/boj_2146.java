import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다리 만들기
public class boj_2146 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    final static int SEA = 0;
    static int minBridgeLen = Integer.MAX_VALUE;
    static Queue<TileInfo> queForBridge = new LinkedList<>();
    static Queue<TileInfo> que = new LinkedList<>();
    static int landNum = 2;
    public static void main(String[] args) throws IOException {
        // 1. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //2. 섬 번호 매기기
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1) setIslandNumbering(i,j);
            }
        }
        // 3. 최소의 다리 짓기
        // 모든 곳에서 시작해서 다리 길이를 재야함
        // 이중 for문 내에서 visited를 매번 초기화하는 이유(debug)
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                // 어떤 섬에서부터 시작해야함.
                if (map[i][j] >= 2) {
                    initVisited();
                    setBridge(i,j);
                }
            }
        }
        System.out.println(minBridgeLen);
    }

    private static void initVisited() {
        for (int i=0; i<N; i++)
            for (int j=0; j<N; j++)
                visited[i][j] = false;
    }
    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }

    private static void setIslandNumbering(int row, int col) {
        que.offer(new TileInfo(row, col, 0));
        visited[row][col] = true;
        map[row][col] = landNum;
        while (!que.isEmpty()) {
            TileInfo t = que.poll();
            for (int i=0; i<dx.length; i++) {
                int nextR = t.row+dx[i];
                int nextC = t.col+dy[i];
                if (!isInBounds(nextR, nextC)) continue;
                if (map[nextR][nextC] == SEA) continue;
                // 방문 안한 섬인 경우
                if (!visited[nextR][nextC]) {
                    que.offer(new TileInfo(nextR, nextC, 0));
                    visited[nextR][nextC] = true;
                    map[nextR][nextC] = landNum;
                }
            }
        }
        landNum++;
    }
    private static void setBridge(int row, int col) {
        queForBridge.offer(new TileInfo(row, col, 0));
        visited[row][col] = true;
        int currLandNum = map[row][col];
        while (!queForBridge.isEmpty()) {
            TileInfo t = queForBridge.poll();
            for (int i=0; i<dx.length; i++) {
                int nextR = t.row + dx[i];
                int nextC = t.col + dy[i];
                if (isInBounds(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] != currLandNum) {
                    visited[nextR][nextC] = true;
                    if (map[nextR][nextC] == SEA) {
                        queForBridge.offer(new TileInfo(nextR, nextC, t.bridgeCnt+1));
                    } else {
                        minBridgeLen = Math.min(minBridgeLen, t.bridgeCnt);
                        queForBridge.clear();
                        return;
                    }
                }
            }
        }
    }
    static class TileInfo {
        private int row;
        private int col;
        private int bridgeCnt;
        public TileInfo(int row, int col, int bridgeCnt) {
            this.row = row;
            this.col = col;
            this.bridgeCnt = bridgeCnt;
        }
    }
}
