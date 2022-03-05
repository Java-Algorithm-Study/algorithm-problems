import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1918 {
    /*

    1. 피연산자의 순서는 그대로이다.
    2. +보다 ( 가 연산 우선순위가 낮다
    3. ( 연산자가 나올 경우 스택에 ‘무조건’ 들어간다. ( 그렇지만 우선순위가낮다)
    4. 스택에 (가 들어가있다면, ) 나올 때 까지 모든 연산자를 스택에 담는다.
    5. 스택에 ) 가 나오면, (가 나올 때 까지 팝해서 뺀다.
    6. 스택(연산자) 쪽에 자기보다 우선수위가 높은 애들을 빼고 push

     */


    public static int swap(int idx) {
        if (idx == 0 || idx == 1) return 1;
        else if (idx == 2 || idx == 3) return 2;
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        // 입력을 한 번에 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 문자열을 토큰화 시킨다.
        char[] ch = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> sk = new Stack(); // 연산자 담을 스택
        String operation = "+-*/)(";
        for (int i = 0; i < ch.length; i++) {
            if (!operation.contains(String.valueOf(ch[i]))) sb.append(ch[i]);
            else { //연산식이 숫자가 아니라면
                if (ch[i] == '(') sk.push(ch[i]);
                else if (ch[i] == ')') { //'('이 나올때까지 문자열에 담아준다.
                    while (!sk.isEmpty() && sk.peek() != '(') {
                        sb.append(sk.pop()); //괄호가 아니면 연산자를 꺼내어 문자열에 담는다.
                    }
                    if (!sk.isEmpty()) sk.pop(); //'('연산자를 꺼내준다.
                } else { // + - / * 연산자 일경우
                    while (!sk.isEmpty() && swap(operation.indexOf(ch[i])) <= swap(operation.indexOf((sk.peek())))) {
                        sb.append(sk.pop());
                    }
                    sk.push(ch[i]);
                }
            }
        }
        while(!sk.isEmpty()) {
            sb.append(sk.pop());
        }
        System.out.println(sb);
    }
}

