import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [1697] 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 *
 * -아이디어
 * 1. N에서 K로 가기 위한 가장 빠른 시간 -> BFS
 * 2. 갈 수 있는 위치: n-1, n+1, 2n
 * 3. 수빈이 위치를 정점, 갈 수 있는 위치를 간선으로 표현.
 * 4. 간선을 최소 개수로 이동하면 된다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj1697 {
    private static int n, k;
    private static int[] distance = new int[100001];
    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(distance[k]);

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = true;
        distance[n] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = x - 1;
            if (0 <= y && y <= 100000 && !visited[y]) {
                visited[y] = true;
                distance[y] = distance[x] + 1;
                queue.add(y);
            }

            y = x + 1;
            if (0 <= y && y <= 100000 && !visited[y]) {
                visited[y] = true;
                distance[y] = distance[x] + 1;
                queue.add(y);
            }

            y = 2 * x;
            if (0 <= y && y <= 100000 && !visited[y]) {
                visited[y] = true;
                distance[y] = distance[x] + 1;
                queue.add(y);
            }
        }
    }
}
