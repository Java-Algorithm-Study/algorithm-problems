import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class boj_10799 {

	public static void main(String[] args) throws IOException {
		boj_10799 boj_10799 = new boj_10799();
//		boj_10799.bazzyung();
		boj_10799.boj(); // 백준 알고리즘 강의 코드
	}
	
	static void bazzyung() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		int result = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				// 열린 괄호면 스택에 추가
				stack.push('(');
				continue;
			} if(input.charAt(i) == ')') {
				// 닫힌 괄호일 경우
				stack.pop(); // 일단 stack에서 pop을 실행
				
				if(input.charAt(i - 1) == '(') {
					// 그 전 괄호가 열린 괄호면 레이저를 의미
					result += stack.size(); // 현재 stack의 사이즈만큼 더해 줌
				} else {
					// 그 전 괄호가 닫힌 괄호면 레이저가 아님
					result++; // 단순히 1을 더해 줌
				}
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void boj() {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine().trim();
		Stack<Integer> stk = new Stack<Integer>();
		int ans = 0;
		
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '(') {
				stk.push(i);
			} else {
				if(stk.peek() + 1 == i) {
					// 그 전 괄호가 열린 괄호면
					stk.pop();
					ans += stk.size();
				} else {
					stk.pop();
					ans += 1;
				}
			}
		}
		System.out.println(ans);
	}
}
