package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Boj_1935 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 피연산자 갯수 입력
        int N = Integer.parseInt(br.readLine());
        // 후위식 문자열 입력
        String [] postfixNdt = br.readLine().split("");


        // 피연산자 갯수가, A-Z의 영대문자를 나타나니, 그걸 한 곳에 담는다.
        // 문제해석 :  (여기서 피연산자는 A~Z의 영대문자이며, A부터 순서대로 N개의 영대문자만이 사용되며, 길이는 100을 넘지 않는다)
        Map<Character, Integer> operation = new HashMap<>();
        int operand;
        for (int i = 0; i < N; i++) {
            // 피연산자 입력
            operand = Integer.parseInt(br.readLine());
            operation.put((char)(65 + i), operand); // 아스키코드 Char =>  65 ~ 90 대문자 A-Z
        }

        Stack<Double> sk = new Stack<>();
        for (int i = 0; i < postfixNdt.length; i++) {
            char oper = postfixNdt[i].charAt(0);
            if (operation.containsKey(oper)) sk.push(Double.valueOf((operation.get(oper))));
            else {
                if (sk.size() < 2) continue;

                Double a, b;
                a = sk.pop();
                b = sk.pop();
                if (oper == '+') sk.push(b + a);
                else if (oper =='-') sk.push(b - a);
                else if (oper == '*') sk.push(b * a);
                else sk.push(b / a);
            }
        }
        System.out.println(String.format("%.2f", sk.pop()));
    }
}
