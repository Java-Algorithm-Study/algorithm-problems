import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [2206] 벽 부수고 이동하기
 * https://www.acmicpc.net/problem/2206
 *
 * -아이디어
 * 1. (1, 1)에서 (N, M)까지의 최단 경로 출력하기 -> BFS, 벽을 최소 한 번 부수어서 칸을 이동할 수 있다.
 * 2. visited[x][y][0] -> 벽을 부수지 않은 상태에서의 해당 칸에 도착하는 데에 이동한 칸의 개수.
 * 3. visited[x][y][1] -> 벽을 부순 상태에서의 해당 칸에 도착하는 데에 이동한 칸의 개수.
 * 4. 다음 칸이 벽이고, 부술 수 있는 상태라면 벽을 부수고 이동했기 때문에 visited[][][1]에 +1을 하고, 큐에 넣을 때 부수었다는 표시로 1을 넣는다.
 * 5. 다음 칸이 벽이 아닐 때는 그냥 이동할 수 있으니까 이전에 벽을 부수었는지에 대한 상태를 그대로 적용해야 한다. 
 * 6. visited[][][이전 값]에 + 1, 큐에도 이전에 벽을 부수었는지 상태를 넣는다.
 *
 */

public class Boj2206 {
    private static class Node {
        int x;
        int y;
        int block; // 블럭 부수었는지의 상태 0: 안 부수었다 1: 부수었다

        public Node(int x, int y, int block) {
            this.x = x;
            this.y = y;
            this.block = block;
        }
    }
    private static int n, m;
    private static int[][] map;
    private static int[][][] visited;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
         }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 0));

        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return visited[node.x][node.y][node.block];
            }

            for (int i = 0; i < dir.length; i++) {
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 ||  ny >= m) {
                    continue;
                }

                // 벽을 만났을 때
                if (map[nx][ny] == 1) {
                    // 이미 벽을 한 번 부수고 온 상태일 때
                    if (node.block == 1) {
                        continue;
                    }
                    // 벽을 부수지 않은 상태일 때
                    else {
                        if (visited[nx][ny][1] > 0) {
                            continue;
                        }
                        // 벽을 부수고, 다음 칸으로 이동한
                        visited[nx][ny][1] = visited[node.x][node.y][node.block] + 1;
                        queue.add(new Node(nx, ny, 1));
                    }
                }

                // 다음 칸이 벽이 아닐 때 (0일 때)
                else {
                    // 이미 방문한 칸일 때
                    if (visited[nx][ny][node.block] > 0) {
                        continue;
                    }
                    visited[nx][ny][node.block] = visited[node.x][node.y][node.block] + 1;
                    queue.add(new Node(nx, ny, node.block));
                }

            }
       }
        return -1;
    }
}
