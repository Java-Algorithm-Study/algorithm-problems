import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [14395] 4 연산
 * https://www.acmicpc.net/problem/14395
 *
 * -아이디어
 * 1. s가 t가 되도록 하는 연산의 경로들을 출력해야 돼서 Node Class에 경로들을 String으로 저장한다.
 * 2. 범위가 1,000,000,000이어서 지역 변수로 visited 할당하면 배열을 초과한다.
 * 3. 범위가 몇으로 갈지 모르니까 set을 사용하여 메모리를 아낀다.
 * 4. BFS로 각 연산을 돌면서 s == t가 될 때 return
 * 5. t == 1인 경우에는 /가 가장 빠르니까 / 출력.
 * 6. while 안에서 연산의 결과 result 조건을 만드는데, <= 0이라면 continue, < t여도 만들 수 없으므로 continue 
 * ---
 * 1. s <= 10^9라는 조건을 잘 보고 타입과 메모리를 잘 생각해야 한다.
 *
 */

public class Boj14395 {
    static class Node {
        long num;
        String op;

        public Node(long num, String op) {
            this.num = num;
            this.op = op;
        }
    }
    private static String[] operators = {"*", "+", "-", "/"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        System.out.println(bfs(s, t));
    }

    private static String bfs(int s, int t) {
        if (s == t) {
            return "0";
        }
        if (t == 1) {
            return "/";
        }

        Queue<Node> queue = new LinkedList<>();
        HashSet<Long> set = new HashSet<>();
        queue.add(new Node(s, ""));
        set.add((long) s);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.num == t) {
                return node.op;
            }

            for (int i = 0; i < operators.length; i++) {
                long result = calculate(node.num, operators[i]);

                if (result <= 0) {
                    continue;
                }

                if (result > t) {
                    continue;
                }

                if (set.contains(result)) {
                    continue;
                }

                queue.add(new Node(result, node.op + operators[i]));
                set.add(result);
            }
        }
        return "-1";
    }

    private static long calculate(long num, String op) {
        switch (op) {
            case "*" :
                num *= num;
                break;

            case "+" :
                num += num;
                break;

            case "-" :
                num -= num;
                break;

            case "/" :
                num /= num;
                break;
        }

        return num;
    }
}
