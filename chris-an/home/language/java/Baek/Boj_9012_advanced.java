package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Boj_9012_advanced {

    private static boolean solution(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        char[] symbols = s.toCharArray(); // 라인의 문자들을 char로 쪼개 배열로 저장

        HashMap<Character, Character> set = new HashMap<>();
        set.put(')', '(');
        set.put('}', '{');
        set.put(']', '[');

        for (char symbol : symbols) {
            // 여는 괄호 '(' 가 나오면 스택에 푸시한다
            if (symbol == '(') {
                stack.push(symbol);
            } else if (symbol == ')') {
                if (stack.empty()) {
                    // 닫는 괄호가 나왔을 때 스택이 비어있으면 오류 출력
                    return false;
                } else {
                    // 닫는 괄호가 나왔을 때 스택이 차 있으면 스택에서 팝한다
                    if (set.get(symbol) == stack.peek()) {
                        stack.pop();
                    } else {
                        return false;
                    }

                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입출력을 위한 BufferedReader 선언

        String parenthesis = bf.readLine(); // 읽어올 라인

        String ans = (solution(parenthesis)) ? "YES" : "NO";
        System.out.println(ans);

    }
}