import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Boj_10845 {
    private static LinkedList<Integer> queue = new LinkedList<>();

    private static void push(int element) {
        queue.add(element);
    }

    private static int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.removeFirst();
    }

    private static int size() {
        return queue.size();
    }

    private static int empty() {
        if (queue.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int front() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peekFirst();
    }

    private static int back() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peekLast();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            String order = bf.readLine();
            // contains를 썼는데 시간복잡도가 증가할 것 같다
            if (order.contains("push")) {
                int number = Integer.parseInt(order.split(" ")[1]);
                push(number);
            } else if (order.equals("pop")) {
                System.out.println(pop());
            } else if (order.equals("size")) {
                System.out.println(size());
            } else if (order.equals("empty")) {
                System.out.println(empty());
            } else if (order.equals("front")) {
                System.out.println(front());
            } else if (order.equals("back")) {
                System.out.println(back());
            }
        }
    }
}
