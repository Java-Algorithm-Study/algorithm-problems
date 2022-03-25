import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                // 레이저 일 때
                if (line.charAt(i - 1) == '(') {
                    result += stack.size();
                } else { result++; }
            }
        }
        System.out.println(result);
    }
}
