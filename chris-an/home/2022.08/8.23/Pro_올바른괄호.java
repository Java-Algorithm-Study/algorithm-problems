public class Pro_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stk.push(c);
            }else {
                if(stk.isEmpty()) return false;
                if(stk.peek() == '(') {
                    stk.pop();
                }else {
                    stk.push(c);
                }
            }
        }

        if(!stk.isEmpty()) answer = false;

        return answer;
    }
}