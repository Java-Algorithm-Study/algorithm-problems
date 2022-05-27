import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [1012] 유기농 배추
 * https://www.acmicpc.net/problem/1012
 *
 * -아이디어
 * 1. map을 돌면서 배추(1)인 곳을 만났을 때 DFS를 돌린다.
 * 2. DFS에서는 상하좌우로 움직이면서 인접한 1이 있을 때까지 돌린다.
 * 3. DFS가 한 번 끝날 때마다 cnt++
 *
 */

public class Boj1012 {
    private static int n, m, k, cnt;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            cnt = 0;
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) {
                        continue;
                    }
                    if (map[i][j] == 0) {
                        continue;
                    }
                    dfs(i, j);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            if (map[nx][ny] == 0) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
    }
}
