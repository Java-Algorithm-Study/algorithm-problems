import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * [2667] 단지번호 붙이기
 * https://www.acmicpc.net/problem/2667
 *
 * -아이디어
 * 1. 상하좌우 격자형에 대해 dir 배열 만든다.
 * 2. 방문했으면 체크
 * 3. 갈 수 있는 집이 나오면, 그 집에서 또 갈 수 있는 집들을 또 방문한다.
 *
 * -시간 복잡도
 * 1. 격자형 그래프 -> DFS, BFS 둘 다 가능.
 * 2. 정점 O(N^2)
 * 3. 간선 O(N^2 * 4)
 * 4. DFS, BFS 둘 다 인접리스트로 간선 관리하면 O(V+E) -> O(N^2)
 *
 * -자료 구조
 * 1.
 */

public class Boj2667 {
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int n;
    private static int cnt = 0;
    private static boolean[][] visited;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        // input
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        // 방문 가능한 집인지 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    answer.add(cnt);
                }
            }
        }
        Collections.sort(answer);
        sb.append(answer.size()).append('\n');

        for (int x : answer) {
            sb.append(x).append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        // 방문 가능한 집이니까 cnt++, 방문 체크
        cnt++;
        visited[x][y] = true;

        // 해당 지점에서 인접한 집 방문하기
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
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
