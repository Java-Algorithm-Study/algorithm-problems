import java.util.Scanner;
import java.util.Stack;

public class Boj_11576 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int base_A = sc.nextInt();
        int digit = sc.nextInt();
        int index = sc.nextInt();
        int n = 0;

        for(int i = index - 1; i >= 0; i--){
            int x = sc.nextInt();
            n += x * Math.pow(base_A, i);
        }

        // 진법으로 나누어주고 나머지를 넣어준다
        while (n != 0) {
            stack.push(n % digit);
            n /= digit;
        }

        while (!stack.isEmpty()) {
            if (stack.size() == 1) System.out.println(stack.peek());
            else System.out.print(stack.peek() + " ");
            stack.pop();
        }

    }
}
