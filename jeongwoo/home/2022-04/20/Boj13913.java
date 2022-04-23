import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * [13913] 숨바꼭질 4
 * https://www.acmicpc.net/problem/13913
 *
 * -아이디어
 * 1. BFS로 n -> k까지 걸리는 최단 시간을 구한다.
 * 2. n == k가 됐을 때까지 지나온 경로를 출력한다.
 * 3. 한 지점을 지날 때마다 어디에서 왔는지 출발지에 대한 정보를 지점을 인덱스로 갖는 배열에 넣는다.
 * 4. n == k일 때, 거쳐온 곳들을 스택에 담는다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj13913 {
    private static int n, k;
    private static int[] distance = new int[100001];
    private static int[] path = new int[100001];
    private static boolean[] visited = new boolean[100001];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(distance[k]);
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = true;
        distance[n] = 0;
        path[n] = n;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == k) {
                Stack<Integer> stack = new Stack<>();
                while (path[x] != x) {
                    stack.add(x);
                    x = path[x];
                }
                stack.add(n);

                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(' ');
                }
                return;
            }

            int y = x - 1;
            if (0 <= y && y <= 100000 && !visited[y]) {
                queue.add(y);
                visited[y] = true;
                distance[y] = distance[x] + 1;
                path[y] = x;
            }

            y = x + 1;
            if (0 <= y && y <= 100000 && !visited[y]) {
                queue.add(y);
                visited[y] = true;
                distance[y] = distance[x] + 1;
                path[y] = x;
            }

            y = x * 2;
            if (0 <= y && y <= 100000 && !visited[y]) {
                queue.add(y);
                visited[y] = true;
                distance[y] = distance[x] + 1;
                path[y] = x;
            }

        }
    }
}
