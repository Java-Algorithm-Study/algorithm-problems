import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [12886] 돌 그룹 
 * https://www.acmicpc.net/problem/12886
 *
 * -아이디어
 * 1. 세 돌 그룹의 합은 그대로 변함이 없다.
 * 2. 총합이 3으로 나누어 떨어지지 않는다면 같은 돌 그룹 개수를 만들 수 없어서 return 0;
 * 3. 먼저 두 개를 받고 큐에 넣고, 큐에서 뽑은 두 숫자로 a, b, c를 알 수 있다.
 * 4. 각각 조건에 맞게 바꿔 주면서 방문 처리를 하고 큐에 다시 넣는다.
 *
 */

public class Boj12886 {
    private static boolean[][] visited = new boolean[1501][1501];
    private static int a, b, c, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sum = a + b + c;

        System.out.println(bfs(a, b));

    }

    private static int bfs(int a, int b) {
        if (sum % 3 != 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(a);
        queue.add(b);

        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int na = queue.poll();
            int nb = queue.poll();
            int c = sum - na - nb;

            if (na == nb && nb == c) {
                return 1;
            }

            step(queue, na, nb);

            step(queue, na, c);

            step(queue, nb, c);
        }
        return 0;
    }

    private static void step(Queue<Integer> queue, int na, int nb) {
        if (na != nb) {
            int a1, b1;

            if (na > nb) {
                b1 = nb * 2;
                a1 = na - nb;
            }
            else {
                a1 = na * 2;
                b1 = nb - na;
            }

            if (!visited[a1][b1]) {
                queue.add(a1);
                queue.add(b1);
                visited[a1][b1] = true;
            }
        }
    }
}
