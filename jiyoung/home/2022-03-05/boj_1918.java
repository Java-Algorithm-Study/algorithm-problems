import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class boj_1918 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		Stack<Character> stk = new Stack<>();
		
		for(Character  ch : str.toCharArray()) {
			if(ch >= 'A' && ch <= 'Z') {
				// 알파벳이면 그대로 출력
				sb.append(ch);
			} else if(ch == '(') {
				// 여는 괄호면
				stk.push(ch);
			} else if(ch == ')') {
				// 닫는 괄호면
				while(!stk.isEmpty()) {
					// 여는 괄호가 나올 때까지 수행
					if(stk.peek() == '(') {
						stk.pop();
						break;
					}
					sb.append(stk.pop());
				}
			} else {
				// 연산자면
				while(!stk.isEmpty() && priority(stk.peek()) >= priority(ch)) {
					sb.append(stk.pop());
				}
				stk.push(ch);
			}
		}
		
		while(!stk.isEmpty()) {
			sb.append(stk.pop());
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	// 연산자 우선순위
	static int priority(char ch) {
		if(ch == '(') {
			return 0;
		} else if(ch == '+' || ch == '-') {
			return 1;
		} else {
			return 2;
		}
	}
}
