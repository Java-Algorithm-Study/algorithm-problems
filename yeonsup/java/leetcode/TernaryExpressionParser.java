package yeonsup.java.leetcode;

import java.util.Stack;

public class TernaryExpressionParser {

    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            if(expression.charAt(i) == '?') {
                Character a = stack.pop();
                Character b = stack.pop();
                if (expression.charAt(i - 1) == 'F')
                    stack.push(b);
                else stack.push(a);

                i--;
            } else if (expression.charAt(i) != ':'){
                stack.push(expression.charAt(i));
            }
        }
        return stack.pop().toString();
    }

    public static void main(String[] args) {
        System.out.println(new TernaryExpressionParser().parseTernary("T?2:3"));
    }

}
