import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [4963] 섬의 개수
 * https://www.acmicpc.net/problem/4963
 *
 * -아이디어
 * 1. 가로, 세로, 대각선을 갈 수 있도록 배열 dir을 만든다.
 * 2. 땅일 때 dir을 탐색한다.
 * 3. 이어진 섬 탐색이 끝날 때마다 cnt++;
 * 4. 총 섬의 개수인 cnt를 출력한다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj4963 {
    private static int w, h;
    private static int[][] map;
    private static boolean[][] visited;
    private static int cnt;
    // 위, 오른쪽, 아래, 왼쪽, 왼쪽 위, 오른쪽 위, 오른쪽 아래, 왼쪽 아래 순서
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int total = 0;

            map = new int[h][w];
            visited = new boolean[h][w];

            // input
            for (int i = 0; i < h; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            // 방문 안 한 땅 찾기
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        cnt = 0;
                        dfs(i, j);
                        if (cnt != 0) {
                            total++;
                        }
                    }
                }
            }
            sb.append(total).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;

        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w ) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            if (map[nx][ny] == 0) {
                continue;
            }
            dfs(nx, ny);
        }
    }
}
