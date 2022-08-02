import java.util.Stack;

/**
 * [12973] 짝지어 제거하기 
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 *
 * -아이디어
 * 1. 문자열 한 글자씩 스택에 넣고, 스택의 맨 위랑 그 다음 문자가 같은지 판단한다.
 * 2. 같다면 pop을 하고, 다르다면 그 다음 문자도 스택에 넣는다.
 * 3. 계속 다음 문자랑 스택의 peek랑 비교하면서 위의 과정을 돌린다.
 * 4. 스택이 비었다면 1, 아니면 0을 출력한다.
 *
 */

public class Pro12973 {
    public static void main(String[] args) {
        String s = "vaav";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char now = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == now) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}
