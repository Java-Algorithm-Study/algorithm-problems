import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * [2146] 다리 만들기
 * https://www.acmicpc.net/problem/2146
 *
 * -아이디어
 * 1. 1번 섬에서 1번 섬으로 가면 안 되니까 각 섬마다 번호를 부여해서 구별한다.
 * 2. 1번 섬에서 2번 섬으로 가는 최단 거리를 구한다.
 * 3. 위처럼 한 섬에서 다른 섬으로 가는 최단 거리를 각자 다 구한다.
 * 4. 구한 최단 거리 중 가장 최솟값을 출력한다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

class Point {
    int x;
    int y;
    int count;

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Boj2146 {
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int min = Integer.MAX_VALUE;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        findIsland();
      
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    setBridge(i, j);
                }
            }
        }
        System.out.println(min);
    }

    private static void findIsland() {
        int idx = 2;
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    map[i][j] = idx;
                    visited[i][j] = true;
                    xQueue.add(i);
                    yQueue.add(j);

                    while (!xQueue.isEmpty()) {
                        int x = xQueue.poll();
                        int y = yQueue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dir[k][0];
                            int ny = y + dir[k][1];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                                continue;
                            }
                            if (map[nx][ny] == 0) {
                                continue;
                            }
                            if (visited[nx][ny]) {
                                continue;
                            }
                            map[nx][ny] = idx;
                            xQueue.add(nx);
                            yQueue.add(ny);
                            visited[nx][ny] = true;
                        }
                    }
                    idx++;
                }

            }

        }
    }

    private static void setBridge(int x, int y) {

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.add(new Point(x, y, 0));

        int idx = map[x][y];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dir[i][0];
                int ny = point.y + dir[i][1];

                if (0 > nx || nx >= n || 0 > ny || ny >= n ) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == idx) {
                    continue;
                }

                visited[nx][ny] = true;

                // 바다인 경우
                if (map[nx][ny] == 0) {
                    queue.add(new Point(nx, ny, point.count + 1));
                }
                else {
                    min = Math.min(min, point.count);
                }
            }
        }

    }
}
