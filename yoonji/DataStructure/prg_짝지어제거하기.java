package DataStructure;

import java.util.Stack;
//알파벳 소문자 문자열 (같은 알파벳 2개 제거)
// 성공 1, 실패 0
// 안에 없으면 넣기. 있으면 top 체크
// 먼저 들어간게 나중에 나온다. 후입선출 => ...스택
// Stack 사용해야 효율성 테스트에서 통과
public class prg_짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char word : s.toCharArray()) {
            if (!stack.isEmpty() && word == stack.peek()) {
                stack.pop();
            } else {
                stack.push(word);
            }
        }
        return stack.isEmpty()? 1: 0;
    }
}