import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 후위 표기식
// 1. input을 돌면서
// 1-1. 피연산자는 문자에 추가한다.
// 1-2. 피연산자가 아니라면
// 1-2-1. '('라면 스택에 넣는다.
// 1-2-2. ')'라면 '('를 만날 때까지 스택에 담아둔 연산자를 pop해서 문자에 추가
//        '('만나면 '(' 연산자를 pop한다.
// 2. + - / * 연산자이면
// 2-1. 스택이 안비고, 현재 연산자보다 우선순위가 높거나 같은 연산자가 스택에 있으면 먼저 출력해줘야하니 꺼내서 문자에 추가
// 주의! '('도 있을텐데. 이를 만나면 더이상 꺼내면 안되니 우선순위를 가장 낮게 한다. (-1)
// 2-2. while문이 끝나면 현재 연산자를 스택에 넣는다.
//3. 스택에 남은 연산자를 모두
// 꺼내서 문자에 추가

// 피연산자의 우선순위는 HashMap으로 처리한다.
// '(' 연산자도 스택에 들어가는데. 우선순위가 높으면 안되므로 -1로 처리
public class boj_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> operStack = new Stack<>();
        Map<Character, Integer> priorMap = new HashMap<>();
        char[] input = br.readLine().toCharArray();
        priorMap.put('+', 0);
        priorMap.put('-', 0);
        priorMap.put('*', 1);
        priorMap.put('/', 1);
        priorMap.put('(', -1);

        for (char c : input) {
            // 1.피연산자면 문자열에 추가
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
            // 2. 괄호이면 스택에 추가
            else if (c == '(') {
                operStack.push(c);
            }
            // 3. 닫힌 괄호이면 열린 괄호를 만날 때까지 문자열에 추가
            else if (c == ')') {
                while (!operStack.isEmpty()) {
                    char pop = operStack.pop(); // 스택에 있는 연산자가 '('가 아닌 이상 문자에 추가
                    if (pop == '(') // 열린 괄호이면 문자에 추가하지 않고 종료
                        break;
                    sb.append(pop);
                }
            }
            // 4. 연산자면 스택에서 피연산자를 꺼내고, 우선순위가 가장 높은 연산자를 먼저 빼서 문자에 추가한다.
            // 괄호 사이에 있던 연산자도 stack에 추가되어있음.
            else {
                while (!operStack.isEmpty() && priorMap.get(operStack.peek()) >= priorMap.get(c)) {  // 스택에 있는 연산자가 더 크면 먼저 출력
                    sb.append(operStack.pop()); // 우선순위가 큰 연산자를 뺴서 문자열에 추가
                }
                // 더이상 추가할 연산자가 없거나 스택에있는 연산자의 우선순위가 더 안높으면? 현재 연산자를 스택(LIFO)에 추가
                operStack.push(c);
            }
        }
        while (!operStack.isEmpty()) sb.append(operStack.pop());
        System.out.println(sb);
    }
}