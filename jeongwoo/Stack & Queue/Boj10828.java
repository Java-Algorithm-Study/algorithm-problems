import java.util.ArrayList;
import java.util.Scanner;

/**
 * [10828] 스택
 * https://www.acmicpc.net/problem/10828
 */

public class Boj10828 {

    private static ArrayList<Integer> stack = new ArrayList<>();

    private static void push(int x) {
        stack.add(x);
    }

    private static int pop() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.remove(stack.size() - 1);
        }
    }

    private static int size() {
        return stack.size();
    }

    private static int empty() {
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int top() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.get(stack.size() - 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            String str = sc.next();

            switch (str) {
                case "push":
                    push(sc.nextInt());
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);

    }
}
