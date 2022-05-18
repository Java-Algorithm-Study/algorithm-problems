import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [16948] 데스 나이트
 * https://www.acmicpc.net/problem/16948
 *
 * -아이디어
 * 1. 최소 이동 횟수니까 BFS로 접근해 본다.
 * 2. bfs 처음 시작할 때 visited, count에 현재 위치에 대한 값을 true, 0으로 넣어 준다.
 * 3. 큐를 탐색하면서 dir로 이동시키면서 방문 처리와 count[i] = count[i] + 1 처리를 한다.
 * 4. count[i]가 0인 경우에는 도달하지 못했으므로 -1를 출력한다.
 * 5. 도달했을 경우에는 count에 있는 값을 출력한다.
 * 
 */

public class Boj16948 {
    private static int n;
    private static int r1, c1, r2, c2;
    private static int[][] dir = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    private static int[][] count;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        count = new int[n][n];
        visited = new boolean[n][n];

        bfs();

        if (count[r2][c2] == 0) {
            count[r2][c2] = -1;
        }

        System.out.println(count[r2][c2]);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(r1);
        queue.add(c1);

        visited[r1][c1] = true;
        count[r1][c1] = 0;

        while (!queue.isEmpty()) {
            int r = queue.poll();;
            int c = queue.poll();

            for (int i = 0; i < dir.length; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                queue.add(nr);
                queue.add(nc);

                visited[nr][nc] = true;
                count[nr][nc] = count[r][c] + 1;
            }
        }
    }
}
