import java.util.LinkedList;
import java.util.Queue;

/**
 * [1844] 게임 맵 최단거리
 * https://programmers.co.kr/learn/courses/30/lessons/1844
 *
 * -아이디어
 * 1. bfs로 (N-1, M-1)까지 가는 가는 거리를 구한다.
 * 2. 범위를 벗어나거나 maps == 1이거나 이미 방문했으면 continue
 * 3. 갈 수 있다면 visited에서 + 1
 *
 */

public class Pro1844 {
    public static void main(String[] args) {
        int[][] input = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(input));
    }

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] visited = new int[n][m];
        Queue<Integer> queue = new LinkedList<>();

        visited[0][0] = 1;
        queue.add(0);
        queue.add(0);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            // n-1, m-1에 도착 시
            if (x == n - 1 && y == m - 1) {
                return visited[n - 1][m - 1];
            }

            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (maps[nx][ny] == 0) {
                    continue;
                }

                if (visited[nx][ny] != 0) {
                    continue;
                }

                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] += visited[x][y] + 1;
            }
        }
        return -1;
    }
}
