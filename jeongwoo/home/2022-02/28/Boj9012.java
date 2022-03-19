import java.util.Scanner;
import java.util.Stack;

/**
 * [9012] 괄호
 * https://www.acmicpc.net/problem/9012
 */

public class Boj9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(checkVPS(sc.next()));
        }
    }

    private static String checkVPS(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }


        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
