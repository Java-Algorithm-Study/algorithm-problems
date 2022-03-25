import java.io.*;
import java.util.*;

/**
 * [1406] 에디터
 * https://www.acmicpc.net/problem/1406
 */

public class Boj1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            left.push(str.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            char ch = command.charAt(0);

            // 커서 왼쪽으로 한 칸, 문장의 맨 앞이면 무시
            if (ch == 'L') {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            }

            // 오른쪽으로 한 칸, 문장의 맨 뒤라면 무시
            else if (ch == 'D') {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            }

            // 왼쪽에 있는 문자 삭제, 문장 맨 앞이면 무시
            else if (ch == 'B') {
                if (!left.isEmpty()) {
                    left.pop();
                }
            }

            // P $ -> $라는 문자를 커서 왼쪽에 추가
            else {
                char word = command.charAt(2);
                left.push(word);
            }

        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            bw.write(right.pop());
        }

        bw.flush();
        bw.close();

    }
}
