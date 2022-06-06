import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [2606] 바이러스 
 * https://www.acmicpc.net/problem/2606
 *
 * -아이디어
 * 1. 1번 컴퓨터부터 시작해서 연결된 컴퓨터들을 다 찾아내야 한다.
 * 2. dfs로 1번에 연결된 컴퓨터 하나에 대해서 연결된 모든 컴퓨터를 탐색한다.
 *
 */

public class Boj2606 {
    private static int[][] map;
    private static boolean[] visited;
    private static int n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        dfs(1);
        System.out.println(ans);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= n; i++) {
            if (map[start][i] == 0) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            ans++;
            dfs(i);
        }
    }
}
