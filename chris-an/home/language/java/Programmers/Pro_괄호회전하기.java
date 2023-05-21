package language.java.Programmers;

import java.util.*;

public class Pro_괄호회전하기 {
    HashMap<Character, Character> parenthesis = new HashMap<>();

    public void init() {
        parenthesis.put('{', '}');
        parenthesis.put('(', ')');
        parenthesis.put('[', ']');
    }

    public boolean isCorrectParenthesis(String s) {
        char c = s.charAt(0);
        if(c == ']' || c == '}' || c == ')') return false;

        Stack<Character> stk = new Stack<>();
        stk.push(c);
        for (int i = 1; i < s.length(); i++) {
            char target = s.charAt(i);
            if(stk.isEmpty()) {
                stk.push(target);
                continue;
            }
            char topParenthesis = stk.peek();
            if(parenthesis.containsKey(topParenthesis)) {
                if(parenthesis.get(topParenthesis) == target) {
                    stk.pop();
                    continue;
                }
            }
            stk.push(target);
        }

        if(stk.isEmpty()) return true;
        else return false;
    }

    public int solution(String s) {
        int count = 0; // 올른 괄호 문자열인 경우를 찾을 경우 +1

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        init();
        for (int i = 0; i < len; i++) {
            sb.append(s.substring(1, len)).append(s.substring(0, 1));
            s = sb.toString();
            sb.setLength(0);

            if(isCorrectParenthesis(s)) {
                count++;
            }
        }
        return count;
    }
}
