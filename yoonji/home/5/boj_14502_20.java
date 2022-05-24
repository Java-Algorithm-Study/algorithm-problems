import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 연구소
public class boj_14502_20 {
    final static int EMPTY = 0;
    final static int WALL = 1;
    final static int VIRUS = 2;
    static int N,M;
    static int[][] map, copyMap;
    static int[] dirY = {1, 0, -1, 0};  // -> ↓ <- ↑
    static int[] dirX = {0, -1, 0, 1};
    static List<Integer[]> virusLocation = new ArrayList<>();
    static int maxSafeZoneCnt = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        initAndGetVirusLocation();
        setWall_DFS(0);
        System.out.println(maxSafeZoneCnt);
    }

    private static void initAndGetVirusLocation() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];
        for (int r=0; r<N; r++) {
            st= new StringTokenizer(br.readLine(), " ");
            for (int c=0; c<M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == VIRUS) virusLocation.add(new Integer[]{r, c});
            }
        }
    }
    private static void setWall_DFS(int depth) {
        if (depth==3) {
            setVirus_BFS();
            return;
        }
        // 모든 칸 방문하면서 3개의 wall setting
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                if (map[r][c] == EMPTY) {
                    map[r][c] = WALL;
                    setWall_DFS(depth+1);
                    map[r][c] = EMPTY;
                }
            }
        }
    }
    private static void setVirus_BFS() {
        deepCopyMap();
        Queue<VirusInfo> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        // virus 넣기
        for (Integer[] virus: virusLocation) {
            visited[virus[0]][virus[1]] = true;
            que.add(new VirusInfo(virus[0], virus[1]));
        }
        while (!que.isEmpty()) {
            VirusInfo now = que.poll();
            for (int i=0; i<4; i++) {
                int nxtRow = now.row+dirY[i];
                int nxtCol = now.col+dirX[i];
                if (nxtRow < 0 || nxtRow >= N || nxtCol < 0 || nxtCol >= M) continue;
                if (visited[nxtRow][nxtCol]) continue;
                if (copyMap[nxtRow][nxtCol] == EMPTY) { // 벽이면 못 뻗어나감
                    copyMap[nxtRow][nxtCol] = VIRUS;
                    que.add(new VirusInfo(nxtRow, nxtCol));
                    visited[nxtRow][nxtCol] = true;
                }
            }
        }
/*        System.out.println("copyMap:");
        for(int[] row : copyMap){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("기존 map:");
        for(int[] row : map){
            System.out.println(Arrays.toString(row));
        }*/

        // 바이러스 세팅 후 안전영역 찾기
        getSafeZone();
    }

    private static void deepCopyMap() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }
    private static void getSafeZone() {
        int safeCnt =0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++)
                if (copyMap[i][j] == EMPTY) safeCnt++;
        }
        maxSafeZoneCnt = Math.max(maxSafeZoneCnt, safeCnt);
    }
    private static class VirusInfo {
        int row;
        int col;
        VirusInfo(int r, int c) {
            this.row =r;
            this.col=c;
        }
    }
}
