import java.io.*;
import java.util.Stack;

/**
 * [1918] 후위 표기식
 * https://www.acmicpc.net/problem/1918
 */


public class Boj1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] ch  = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char x : ch) {
            if (Character.isAlphabetic(x)) {
                sb.append(x);
            }
            else if (x == '('){
                stack.push(x);
            }
            else if (x == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            // 연산자일 경우, stack.peek()의 우선순위가 현재 연산자의 우선순위보다 높거나 같을 경우 pop
            // 작다면 현재 연산자를 push
            else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(x)) {
                    sb.append(stack.pop());
                }
                stack.push(x);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static int priority(char x) {
        if (x == '(' || x == ')') {
            return 0;
        }
        else if (x == '+' || x == '-') {
            return 1;
        }
        else {
            return 2;
        }
    }
}
