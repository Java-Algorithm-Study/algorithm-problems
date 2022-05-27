import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [16946] 벽 부수고 이동하기 4
 * https://www.acmicpc.net/problem/16946
 *
 * -아이디어
 * 1. 이동은 상하좌우로만 할 수 있다.
 * 2. 벽을 만나면 벽을 부수고 0으로 변경 후, 이동할 수 있는 칸의 개수를 출력한다.
 * 3. 벽을 만났을 때, 0으로 한 다음에 BFS를 돌면서 0을 카운팅한다. 카운팅 후 10으로 나눈 나머지를 출력한다.
 * -- 시간 초과
 * 1. 빈 공간(0)을 탐색하면서 이동 가능한 칸을 카운팅하고, 같은 이동 영역 내에 있는 0들을 그룹으로 묶는다.
 * 2. 그룹 배열에 각 그룹별(인덱스)로 이동 가능한 칸을 넣는다.
 * 3. 벽(1)을 만나면 상하좌우에 몇 번 그룹이 있는지 확인하고, 그 수만큼 더한다.
 * 4. 더한 값들을 10으로 나눈 나머지를 구해서 출력한다.
 *
 */

public class Boj16946 {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] group;
    private static int groupId;
    private static int[] groupCnt;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        group = new int[n][m];
        groupId = 1;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (map[i][j] == 1) {
                    continue;
                }
                // map[i][j] == 0일 때 같은 영역에 있는 0을 group 배열을 통해 같은 그룹으로 만들어 준다.
                bfs(i, j);
                groupId++;
            }
        }

        groupCnt = new int[groupId];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                groupCnt[group[i][j]]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    sb.append('0');
                }
                // map[i][j] == 1일 때 상하좌우에 있는 그룹 번호를 담는다.
                else {
                    // 인접한 그룹이 같은 id를 공유하는 같은 그룹일 수 있으니까 set에 그룹 id를 저장한다.
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < dir.length; k++) {
                        int ni = i + dir[k][0];
                        int nj = j + dir[k][1];

                        if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                            continue;
                        }
                        if (group[ni][nj] == 0) {
                            continue;
                        }
                        set.add(group[ni][nj]);
                    }

                    int cnt = 1;
                    for (int x : set) {
                        cnt += groupCnt[x];
                    }
                    sb.append(cnt % 10);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();

            group[row][col] = groupId;

            for (int i = 0; i < dir.length; i++) {
                int nx = row + dir[i][0];
                int ny = col + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    continue;
                }
                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] = true;
            }
        }
    }
}
