import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [1926] 그림
 * https://www.acmicpc.net/problem/1926
 *
 * -아이디어
 * 1. 그림 개수 체크해야 되니까 main에서 한 줄씩 보면서 visited 체크하고, BFS 돌릴 때마다 cnt++
 * 2. 가장 큰 면적 구하기 위해서는 BFS에서는 상하좌우 체크하면서 큐에서 하나 뺄 때마다 size++
 * 3. return으로 최대값 보내서 갱신한다.
 *
 * -시간 복잡도
 * 1. O(V+E) = 1,250,00 < 2억
 * 2. V = N * M = 500 * 500
 * 3. E <= 4*V = 1,000,000
 */

public class Boj1926 {
    private static int n, m;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (map[i][j] == 0) {
                    continue;
                }
                max = Math.max(bfs(i, j), max);
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(max);

    }

    private static int bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();

        int size = 0;
        queue.add(x);
        queue.add(y);
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int nowX = queue.poll();
            int nowY = queue.poll();

            for (int i = 0; i < dir.length; i++) {
                int newX = nowX + dir[i][0];
                int newY = nowY + dir[i][1];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }

                if (map[newX][newY] == 0) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                visited[newX][newY] = true;
                queue.add(newX);
                queue.add(newY);
            }
            size++;
        }
        return size;
    }
}
