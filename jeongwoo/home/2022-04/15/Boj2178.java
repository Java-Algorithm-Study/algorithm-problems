import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [2178] 미로 탐색
 * https://www.acmicpc.net/problem/2178
 *
 * -아이디어
 * -> 최단 경로의 경우 BFS로!
 * 1. (1, 1) 출발 (N, M) 도착할 때까지 지나야 하는 최소 칸 수를 구해야 됨.
 * 2. 인접한 상하좌우 칸만 갈 수 있으니까 dir 배열 생성.
 * 3. 이동 횟수에 대한 배열 distance 생성
 * 4. 1이면 가고, 0은 못 감.
 * 5. 한 칸씩 지날 때마다 +1
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj2178 {
    private static int n, m;
    private static int[][] map;
    private static int[][] distance;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        distance = new int[n][m];

        // input
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(distance[n-1][m-1]);
    }

    private static void bfs(int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = -1;
            }
        }

        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        xQueue.add(x);
        yQueue.add(y);
        // 시작점부터 1
        distance[x][y] = 1;

        while (!xQueue.isEmpty()) {
            x = xQueue.poll();
            y = yQueue.poll();

            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    continue;
                }
                if (distance[nx][ny] != -1) {
                    continue;
                }
                xQueue.add(nx);
                yQueue.add(ny);
                distance[nx][ny] = distance[x][y] + 1;
            }

        }

    }
}
