package DataStructure;

import java.util.Stack;

// Stack 사용해야 효율성 테스트에서 통과
public class prg_짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0? 1: 0;
    }
}