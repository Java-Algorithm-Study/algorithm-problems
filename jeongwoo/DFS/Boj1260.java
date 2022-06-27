import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [1260] DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 *
 * -아이디어
 * 1. 정점의 개수 N, 간선 개수 M, 탐색 시작할 정점 번호 V
 * 2. M개의 간선 연결 정보가 입력으로 주어짐. 간선은 양방향.
 * 3. 간선 연결 정보는 행렬로 받는다. 이어진 정점이면 1, 아니면 0
 * 4. dfs는 재귀로, bfs는 큐로 구현.
 * 5. dfs: x가 인자로 오면 x를 방문할 수 있다는 것을 알고 방문한 상태.
 * 그래서 visited 체크를 하고, x에서 갈 수 있는 곳들을 모두 방문한다.
 * i를 이미 갈 수 있다는 사실을 안다면 갈 필요 없다.
 * 그 다음 i에서 갈 수 있는 곳들도 체크해 주자.
 * 6. bfs: queue에 방문 가능한 점을 넣어 준다.
 * visited 체크를 하고, x에서 갈 수 있는 곳들을 모두 방문한다.
 * poll로 꺼내서 그 점들에 갈 수 있는지 체크한다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj1260 {
    private static int[][] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            arr[m1][m2] = arr[m2][m1] = 1;
        }
        dfs(v);
        sb.append('\n');

        for (int i = 1; i < arr.length; i++) {
            visited[i] = false;
        }

        bfs(v);

        System.out.println(sb);
    }

    private static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(' ');

        for (int i = 1; i < arr.length; i++) {
            if (arr[x][i] == 0) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            dfs(i);
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            x = queue.poll();
            sb.append(x).append(' ');
            for (int i = 1; i < arr.length; i++) {
                if (arr[x][i] == 0) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }
                queue.add(i);
                visited[i] = true;
            }
        }
    }
}
