// 프로그래머스 짝지어 제거하기
// https://programmers.co.kr/learn/courses/30/lessons/12973
import java.util.Stack;

public class Pro_12973 {
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            }else {
                char tmp = stack.peek();
                if (tmp == c) stack.pop();
                else stack.add(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
