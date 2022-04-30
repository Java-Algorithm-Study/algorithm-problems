import java.util.Stack;

public class Pro_60058 {
    public static StringBuilder sb = new StringBuilder();
    
    public static String solution(String p) {
        if (isPerfect(p)) return p;
        split(p);
        return sb.toString();
    }
    
    public static void split(String str) {
        if (str.length() == 0) return;
        int count = 0;
        int index = 0;
        
        // 균형잡힌 괄호열로 분리
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            else count--;
            
            if (count == 0) {
                index = i;
                break;
            }
        }
        String u = str.substring(0, index + 1);
        String v = str.substring(index + 1);
        
        // u가 올바른 괄호열일 경우
        if (isPerfect(u)) {
            sb.append(u);
            split(v);
        }
        // u가 올바른 괄호열이 아닐 경우
        else {
            sb.append('(');
            split(v);
            sb.append(')');
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') temp.append(')');
                else temp.append('(');
            }
            sb.append(temp);
        }
    }
    
    public static boolean isPerfect(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch: str.toCharArray()) {
            if (ch == '(') stack.push('(');
            else if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String str1 = "(()())()";
        String str2 = ")(";
        String str3 = "()))((()";
        String str4 = "))((";
        String str5 = "()()";
        String str6 = ")()(()";
        String str7 = "())(()";
        String str8 = "))))((((";
        String str9 = "))()((";
        String str10 = ")()()()(";
        System.out.println(solution(str10));
    }
}
