package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [2178] 미로탐색
 * https://www.acmicpc.net/problem/2178
 *
 * -아이디어
 * 인접한 곳을 확인해서 가장 먼저 (N,M)에 도착하는 경우가 최소이다. -> BFS
 * 인접한 경우를 모두 FIFO 자료구조에 넣어야 한다. (재귀가 아닌..)
 * 이미 방문표시된 블록은 최소경로가 지나갔으므로 방문햘 필요 없다.
 *
 * -시간복잡도
 * O(NM) (참고 :https://www.acmicpc.net/problem/2178)
 **/

public class boj_2178_미로탐색 {
    static boolean[][] visited;
    static int[][] grid;
    static int N,M;
    static int[][] dir = {{0, 1, 0, -1}, {1, 0, -1, 0}};
    static final int BLOCKED = 0;
    public static void main(String[] args) throws IOException {
        /* init */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        /* find result by BFS */
        int minCase = findCaseByBFS();   // 출발지 포함이므로 1로 시작.
        if (minCase==-1) {
            System.out.println("최종 목적지에 도달할 수 없습니다.");
        } else {
            System.out.println("최종 목적지에 도달하는 최소 이동 횟수: "+ minCase);
        }
    }

    public static int findCaseByBFS() {
        Queue<GridInfo> q = new LinkedList<>();
        q.add(new GridInfo(0, 0, 1));

        while (!q.isEmpty()) {
            GridInfo currGrid = q.poll();

            for (int i=0; i<4; i++) {
                if (currGrid.r+1==N && currGrid.c+1==M) {
                    return currGrid.moveCnt;
                }
                // 이동 가능한 범위인지 확인
                int nextRow = currGrid.r + dir[0][i];
                int nextCol = currGrid.c + dir[1][i];
                if (isOutBounds(nextRow, nextCol)) continue;
                if (grid[nextRow][nextCol] == BLOCKED) continue;
                if (visited[nextRow][nextCol]) continue;

                visited[nextRow][nextCol] = true;
                q.add(new GridInfo(nextRow, nextCol, currGrid.moveCnt+1));
            }
        }
        return -1;
    }

    private static boolean isOutBounds(int row, int col) {
        return row < 0 || col < 0 || row >= N || col >= M;
    }


    private static class GridInfo {
        private final int r;
        private final int c;
        private final int moveCnt;

        private GridInfo(int r, int c, int moveCnt) {
            this.r = r;
            this.c = c;
            this.moveCnt = moveCnt;
        }
    }
}