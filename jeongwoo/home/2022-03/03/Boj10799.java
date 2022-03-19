import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [10799] 쇠막대기
 * https://www.acmicpc.net/problem/10799
 */

public class Boj10799 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int cnt = 0;

        stack.push(ch[0]);

        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(ch[i]);
            }

            if (!stack.isEmpty() && ch[i] == ')' && ch[i-1] == '(') {
                stack.pop();
                cnt += stack.size();
            }
            if (!stack.empty() && ch[i] == ')' && ch[i-1] != '(' ) {
                stack.pop();
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
