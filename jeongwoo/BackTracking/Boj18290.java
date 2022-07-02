import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [18290] NM과 K (1)
 * https://www.acmicpc.net/problem/18290
 *
 * -아이디어
 * 1. map[i][j]에 방문이 가능하다면 상하좌우도 방문 처리를 한다.
 * 2. 방문이 가능한 k개를 골라 Max를 찾는다.
 * 3. *** visited를 boolean으로 선언한다면 중복된 인접한 칸에 대해 true가 false 처리돼서 인접한 칸인데 방문이 가능해진다. ***
 */

public class Boj18290 {
    private static int n, m, k;
    private static int[][] map;
    private static int[][] visited; // visited == 0 : not visited, visited > 0 : visited
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);
        System.out.println(max);

    }

    private static void backTracking(int cnt, int sum) {
        if (cnt == k) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] > 0) {
                    continue;
                }

                visited[i][j]++;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    visited[nx][ny]++;
                }

                backTracking(cnt + 1, sum + map[i][j]);

                visited[i][j]--;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    visited[nx][ny]--;
                }
            }
        }
    }
}
