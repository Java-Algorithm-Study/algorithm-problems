import java.io.*;
import java.util.*;

/**
 * [10845] 큐
 * https://www.acmicpc.net/problem/10845
 */

public class Boj10845 {
    private static ArrayList<Integer> queue = new ArrayList<>();

    private static void push(int x) {
        queue.add(x);
    }

    private static int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.remove(0);
    }

    private static int size() {
        return queue.size();
    }

    private static int empty() {
        if (queue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static int front() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.get(0);
    }

    private static int back() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.get(queue.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            String str = sc.next();

            switch (str) {
                case "push" :
                    push(sc.nextInt());
                    break;

                case "pop" :
                    sb.append(pop()).append('\n');
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
