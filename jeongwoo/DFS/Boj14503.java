import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [14503] 로봇 청소기
 * https://www.acmicpc.net/problem/14503
 *
 * -아이디어
 * 1. 현재 위치가 0(청소 X)라면 2(청소)로 만든다.
 * 2. 현재 위치가 벽이면 return
 * 3. 청소 안 했으면 하고, 이미 했다면 왼쪽으로 방향을 바꾼다.
 * 4. 왼쪽으로 바꾼 방향의 방이 0이면 청소한다. -> 1로 간다.
 * 5. 다 청소했거나 벽이라면 현재 방향을 유지하면서 뒤로 후진한다.
 * 6. 후진했을 때 현재 위치가 벽이라면 (2) return
 * 
 */

public class Boj14503 {
    private static int n, m;
    private static int count;
    private static int[][] map;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(x, y, d);
        System.out.println(count);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private static void dfs(int x, int y, int d) {
        if (map[x][y] == 1) {
            return;
        }
        else if (map[x][y] == 0) {
            clean(x, y);
        }

        int nd = d;
        for (int i = 0; i < dir.length; i++) {
            nd = (nd + 3) % 4;
            int nx = x + dir[nd][0];
            int ny = y + dir[nd][1];

            // 왼쪽으로 돌린 방향이 청소 안 한 방이라면
            if (map[nx][ny] == 0) {
                dfs(nx, ny, nd);
                return;
            }
        }

        // 다 청소했거나 벽인 경우, 방향은 그대로 하고, 후진
        dfs(x - dir[d][0], y - dir[d][1], d);
    }

    // 청소 완료하면 2로 바꾸고, count++
    private static void clean(int x, int y) {
        map[x][y] = 2;
        count++;
    }
}
