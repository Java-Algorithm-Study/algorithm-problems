import java.io.*;
import java.util.*;

/**
 * [10866] 덱
 * https://www.acmicpc.net/problem/10866
 */

public class Boj10866 {
    private static List<Integer> deque = new LinkedList<>();

    private static void push_front(int x) {
        deque.add(0, x);
    }

    private static void push_back(int x) {
        if (deque.isEmpty()) {
            deque.add(x);
        }
        else {
            // 한칸씩 앞으로 가야 함.
            deque.add(deque.size(), x);
        }
    }

    private static int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.remove(0);
    }

    private static int pop_back() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.remove(deque.size() - 1);
    }

    private static int size() {
        return deque.size();
    }

    private static int empty() {
        if (deque.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static int front() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.get(0);
    }

    private static int back() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.get(deque.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            String str = sc.next();

            switch (str) {
                case "push_front" :
                    push_front(sc.nextInt());
                    break;

                case "push_back" :
                    push_back(sc.nextInt());
                    break;

                case "pop_front" :
                    sb.append(pop_front()).append('\n');
                    break;

                case "pop_back" :
                    sb.append(pop_back()).append('\n');
                    break;

                case "size" :
                    sb.append(size()).append('\n');
                    break;

                case "empty" :
                    sb.append(empty()).append('\n');
                    break;

                case "front" :
                    sb.append(front()).append('\n');
                    break;

                case "back" :
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
