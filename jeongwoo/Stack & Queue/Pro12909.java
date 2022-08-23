import java.util.*;

/**
 * [12909] 올바른 괄호 
 * https://programmers.co.kr/learn/courses/30/lessons/12909
 *
 * -아이디어
 * 1. '('가 들어오면 스택에 넣는다.
 * 2. ')' 만났을 때, 스택이 empty가 아니라면 pop을 한다. -> () 만나서 제거.
 * 3. ')' 만났을 때, 스택이 비어 있다면 올바른 괄호가 아니므로 break
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */
 
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        char[] chArray = s.toCharArray();
        stack.push(chArray[0]);
        boolean flag = false;
        for (int i = 1; i < chArray.length; i++) {
            char now = chArray[i];
            
            if (now == ')') {
                if (stack.isEmpty()) {
                    flag = true;
                    break;
                }
                stack.pop();
            }
            else {
                stack.push(now);
            }
        }
        
        if (!flag && stack.isEmpty()) {
            answer = true;
        }
        
        return answer;
    }
}
