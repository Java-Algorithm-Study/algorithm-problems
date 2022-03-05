import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * [9012] 괄호 : ()뿐만 아니라 {, [, ], } 추가
 * https://www.acmicpc.net/problem/9012
 */

public class Boj9012plus {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            System.out.println(checkVPS(br.readLine()));
            stack.clear();
        }
    }

    private static boolean checkVPS(String line) {
        if (line.length() %2 !=0) return false; // 만약 길이가 홀수일 경우 return false

        for (char ch : line.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            }
            // 닫힌 괄호인 경우
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    Character peek = stack.peek();
                    if (ch == ')') {
                        if (peek =='(') stack.pop();
                        else return false;
                    }
                    else if (ch == '}') {
                        if (peek =='{') stack.pop();
                        else return false;
                    }
                    else {
                        if (peek =='[') stack.pop();
                        else return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
