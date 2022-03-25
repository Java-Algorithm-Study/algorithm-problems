import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [17413] 단어 뒤집기 2
 * https://www.acmicpc.net/problem/17413
 */

public class Boj17413 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        int idx = 0;
        int cnt = 0;
      
        // 여는 괄호 만나면 닫는 괄호 나올 때까지 leftStack에 push
        // 문자를 만나면 공백이 나올 때가지 rightStack에 push
      
        while (idx < ch.length) {
            if (ch[idx] == '<') {
                while (ch[idx] != '>') {
                    leftStack.push(ch[idx++]);
                }
                leftStack.push(ch[idx++]);
            }
            else {
                    while (idx < ch.length && ch[idx] != ' ' && ch[idx] != '<') {
                        rightStack.push(ch[idx++]);
                        cnt++;
                    }
                    while (cnt != 0) {
                        leftStack.push(rightStack.pop());
                        cnt--;
                    }
                    if (idx < ch.length && ch[idx] == ' ') {
                        leftStack.push(ch[idx++]);
                    }
                }
        }

        for (int i = 0; i < leftStack.size(); i++) {
            System.out.print(leftStack.get(i));
        }


    }
}
