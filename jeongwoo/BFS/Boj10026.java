import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [10026] 적록색약
 * https://www.acmicpc.net/problem/10026
 *
 * -아이디어
 * 1. 적록색약이 아닌 사람은 visited 체크를 for문 돌면서 하면서 각각의 색이 몇 개 있는지 카운팅한다.
 * 2. 적록색약인 사람은 인풋을 받을 때 R과 G를 같은 색으로 보니까 G가 들어오면 R을 map에 넣는다.
 * 3. 적록색약이 아닌 사람과 동일하게 한 색깔씩 탐색하면서 총 몇 개의 구간이 있는지 카운팅한다.
 *
 */

public class Boj10026 {
    private static int n;
    private static char[][] rgbrMap, rgMap;
    private static boolean[][] visited;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        rgbrMap = new char[n][n];
        rgMap = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                rgbrMap[i][j] = input[j];

                if (input[j] == 'G') {
                    rgMap[i][j] = 'R';
                }
                else {
                    rgMap[i][j] = input[j];
                }
            }
        }

        int rgbrCnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                bfs(i, j, rgbrMap);
                rgbrCnt++;
            }
        }

        int rgCnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                bfs(i, j, rgMap);
                rgCnt++;
            }
        }


        System.out.println(rgbrCnt + " " + rgCnt);

    }

    private static void bfs(int x, int y, char[][] map) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int nowX = queue.poll();
            int nowY = queue.poll();

            for (int i = 0 ; i < dir.length; i++) {
                int newX = nowX + dir[i][0];
                int newY = nowY + dir[i][1];

                if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                if (map[nowX][nowY] != map[newX][newY]) {
                    continue;
                }

                queue.add(newX);
                queue.add(newY);
                visited[newX][newY] = true;
            }
        }
    }
}
