import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Boj_10866 {

    private static LinkedList<Integer> deque = new LinkedList<>();

    private static void push_front(int element) { deque.addFirst(element); }
    private static void push_back(int element) { deque.addLast(element); }

    private static int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.removeFirst();
    }

    private static int pop_back() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.removeLast();
    }

    private static int front() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    private static int back() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekLast();
    }

    private static int size() { return deque.size(); }

    private static int isEmpty() {
        if (size() > 0) {
            return 0;
        } else {
            return 1;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            String order = bf.readLine();
            if (order.contains("push_front")) {
                int number = Integer.parseInt(order.split(" ")[1]);
                push_front(number);
            } else if (order.contains("push_back")) {
                int number = Integer.parseInt(order.split(" ")[1]);
                push_back(number);
            } else if (order.equals("pop_front")) {
                System.out.println(pop_front());
            } else if (order.equals("pop_back")) {
                System.out.println(pop_back());
            } else if (order.equals("size")) {
                System.out.println(size());
            } else if (order.equals("empty")) {
                System.out.println(isEmpty());
            } else if (order.equals("front")) {
                System.out.println(front());
            } else if (order.equals("back")) {
                System.out.println(back());
            }
        }

    }
}