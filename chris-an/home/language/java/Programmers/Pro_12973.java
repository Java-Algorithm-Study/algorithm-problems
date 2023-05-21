package language.java.Programmers;

import java.util.*;

public class Pro_12973 {
        /*
        카카오 문제랑 비슷한 거 같음.
        Stack 자료구조를 이용
        순차적(while)으로 돌리면서

        마지막에 입력값이 없을 경우 1, 있을 경우 0
    */

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
