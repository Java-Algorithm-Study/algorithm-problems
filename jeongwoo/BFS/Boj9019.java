import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [9019] DSLR
 * https://www.acmicpc.net/problem/9019
 *
 * -아이디어
 * 1. 연산 결과와 연산 방법을 담을 Node Class를 만든다.
 * 2. 4가지 연산을 하면서 그 결과와 누적된 연산 방법을 큐에 넣는다.
 * 3. 큐에서 poll 할 때마다 만들어야 하는 숫자와 같은지 체크한다.
 * 
 */

public class Boj9019 {
    private static class Node {
        int num;
        String result;

        Node(int n, String r) {
            this.num = n;
            this.result = r;
        }
    }

    private static char[] operator = {'D', 'S', 'L', 'R'};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfs(a, b);
        }

        System.out.println(sb);
    }

    private static void bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        queue.add(new Node(a, ""));
        visited[a] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.num == b) {
                sb.append(now.result).append('\n');
                return;
            }

            for (int i = 0; i < operator.length; i++) {
                int after = operate(operator[i], now.num);

                if (visited[after]) {
                    continue;
                }

                queue.add(new Node(after, now.result + operator[i]));
                visited[after] = true;
            }
        }
    }

    private static int operate(char op, int n) {
        switch (op) {
            case 'D' :
                n *= 2;
                if (n > 9999) {
                    n %= 10000;
                }
                break;

            case 'S' :
                n = (n == 0) ? 9999 : n - 1;
                break;

            case 'L' :
                n = n % 1000 * 10 + n / 1000;
                break;

            case 'R' :
                n = n % 10 * 1000 + n / 10;
                break;
        }
        return n;
    }
}
