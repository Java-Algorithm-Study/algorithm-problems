import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [16928] 뱀과 사다리 게임
 * https://www.acmicpc.net/problem/16928
 *
 * -아이디어
 * 1. 최단 거리 문제 -> BFS로 접근해 본다.
 * 2. info[]에 사다리, 뱀에 대한 정보를 넣는다. x -> y라면 info[x] = y
 * 3. BFS 시작 시 위치 1에 대해서 visited 체크를 하고, count[1] = 0 -> 첫 시작이니까.
 * 4. 원래 위치에서 +1 ~ +6 (주사위)를 하면서 visited 체크가 돼 있는지 확인한다.
 * 5. 이미 방문한 곳이라면 넘기고, 위치가 100을 넘어도 continue
 * 6. 방문 예정인 곳(x)에 대해 info[x] 값이 있다면 info[x] 값이 visited 됐는지 본다. 방문하지 않은 곳이라면 큐에 넣고 cnt는 현재 있는 곳의 값에서 + 1
 * 7. 방문 예정인 곳(x)에 대해 info[x] 값이 없다면 큐에 넣어 주고, cnt는 현재 있는 곳의 값에서 + 1
 *
 */

public class Boj16928 {
    private static int[] info = new int[101];
    private static int[] count = new int[101];
    private static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            info[x] = y;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;
        count[1] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == 100) {
                System.out.println(count[now]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int x = now + i;

                if (x > 100) {
                    continue;
                }
                if (visited[x]) {
                    continue;
                }
                visited[x] = true;

                if (info[x] > 0) {
                    if (visited[info[x]]) {
                        continue;
                    }
                    queue.offer(info[x]);
                    visited[info[x]] = true;
                    count[info[x]] = count[now] + 1;
                }
                else {
                    queue.offer(x);
                    count[x] = count[now] + 1;
                }
            }

        }
    }
}
