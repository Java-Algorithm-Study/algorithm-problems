import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [7576] 토마토
 * https://www.acmicpc.net/problem/7576
 *
 * -아이디어
 * 1. 익은 토마토(1)의 상하좌우에 안 익은 토마토(0)이 있으면 안 익은 토마토 칸에 +1을 한다. -> 익은 토마토가 됨
 * 2. 입력 받을 때 익은 토마토(1)이 들어오면 큐에 넣는다.
 * 3. 안 익은 토마토(0)이 있다면 -1을 출력
 * 4. 처음 입력값이 다 1이라면 date = 1이므로 return 0
 *
 */

public class Boj7576 {
    private static int n, m;
    private static int[][] map;
    private static Queue<Integer> queue;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        queue = new LinkedList<>();

        for (int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y] + 1;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }
        int date = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                date = Math.max(date, map[i][j]);
            }
        }
        if (date == 1) {
            return 0;
        }

        return date - 1;
    }
}
