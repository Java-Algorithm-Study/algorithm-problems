import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [17086] 아기 상어 2
 * https://www.acmicpc.net/problem/17086
 *
 * -아이디어
 * 1. 0인 칸에서 상하좌우대각선 총 8방향을 돌면서 1이 있는지 BFS로 확인한다.
 * 2. 1을 만나자마자 bfs는 끝내고 해당 배열에 거리를 저장한다.
 * 3. 0인 칸들을 다 돌면 정답이 있는 배열에서 max값을 뽑는다.
 *
 */

public class Boj17086 {
    private static int[][] map;
    private static int[][] cnt;
    private static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cnt = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    cnt[i][j] = bfs(i, j);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, cnt[i][j]);
            }
        }

        System.out.println(max);
        
    }

    private static int bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(x);
        queue.add(y);
        queue.add(0);
//        cnt[x][y] = 0;

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int col = queue.poll();
            int row = queue.poll();
            int count = queue.poll();

//            if (map[col][row] == 1) {
////                return cnt[col][row];
//                return count;
//            }

            for (int i = 0; i < dir.length; i++) {
                int nc = col + dir[i][0];
                int nr = row + dir[i][1];
                int nCnt = count + 1;

                if (nc < 0 || nc >= n || nr < 0 || nr >= m) {
                    continue;
                }
                if (visited[nc][nr]) {
                    continue;
                }

                if (map[nc][nr] == 1) {
                    return nCnt;
                }
                queue.add(nc);
                queue.add(nr);
                queue.add(nCnt);
//                cnt[nc][nr] = cnt[col][row] + 1;
                visited[nc][nr] = true;

            }
        }
        return 0;
    }
}
