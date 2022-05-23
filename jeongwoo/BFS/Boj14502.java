import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [14502] 연구소
 * https://www.acmicpc.net/problem/14502
 *
 * -아이디어
 * 1. 바이러스(2)를 만나면 dfs로 벽돌 3개를 세운다.
 * 2. 벽돌 세 개를 다 세웠으면 bfs로 바이러스(2)를 뿌린다. 이때 map은 새로 복사해야 한다.
 * 3. 뿌린 후에 0이 몇 개가 있는지 확인하고 max에 갱신한다.
 *
 */

public class Boj14502 {
    private static int n, m;
    private static int[][] map;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);

    }

    private static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int[][] copiedMap = new int[n][m];
        for (int i = 0; i < copiedMap.length; i++) {
            System.arraycopy(map[i], 0, copiedMap[i], 0, map[0].length);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copiedMap[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (copiedMap[nx][ny] == 0) {
                    copiedMap[nx][ny] = 1;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }

        findZero(copiedMap);
    }

    private static void findZero(int[][] cm) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cm[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(cnt, max);
    }
}
