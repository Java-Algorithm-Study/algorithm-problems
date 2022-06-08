import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [11724] 연결 요소의 개수
 * https://www.acmicpc.net/problem/11724
 *
 * -아이디어
 * 1. 각 노드끼리 연결 여부를 1로 확인해서, 1이라면 연결됐으니까 dfs로 연결된 지점을 더 찾는다.
 * 
 */

public class Boj11724 {
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        int cnt = 0;

        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i, map);
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void dfs(int start, int[][] map) {
        visited[start] = true;

        for (int i = 1; i < map.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (map[start][i] == 0) {
                continue;
            }
            dfs(i, map);
        }
    }
}
