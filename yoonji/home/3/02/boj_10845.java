import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
// 큐를 구현한 ArrayDeque
public class boj_10845 {
    public static void main(String[] args) throws IOException {
        Deque<String> deque = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            // 1. 명령을 입력받는다.
            String[] line = br.readLine().split(" ");
            // 1-1. charAt(0)으로 p인 것, 그외로 구분
            switch (line[0]) {
                case "push": deque.add(line[1]); break;
                case "pop": removeFirst(deque); break;
                case "size": print(deque.size());break;
                case "empty" :
                    if (deque.isEmpty()) print(1);
                    else print(0);
                    break;
                case "front":
                    if (deque.isEmpty()) print(-1);
                    else print(deque.peekFirst());
                    break;
                default:
                    if (deque.isEmpty()) print(-1);
                    else print(deque.peekLast());
                    break;
            }
        }
    }
    private static void removeFirst(Deque<String> q) {
        if (q.isEmpty()) print(-1);
        else print(q.removeFirst());
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
