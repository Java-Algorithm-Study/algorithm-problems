import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_9012 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입출력을 위한 BufferedReader 선언 
		int N = Integer.parseInt(bf.readLine()); // 읽어올 라인의 갯수 
		for (int i = 0; i < N; i++) {
			String answer = "YES";
			Stack<Integer> stack = new Stack<>();
			String parenthesis = bf.readLine(); // 읽어올 라인들 
			char[] symbols = parenthesis.toCharArray(); // 라인의 문자들을 char로 쪼개 배열로 저장 
			for (char symbol : symbols) {
				// 여는 괄호 '(' 가 나오면 스택에 푸시한
				if (symbol == '(') {
					stack.push(0);
				} else if (symbol == ')') {
					if (stack.empty()) {
						// 닫는 괄호가 나왔을 때 스택이 비어있으면 오류 출력 
						answer = "NO";
					} else {
						// 닫는 괄호가 나왔을 때 스택이 차 있으면 스택에서 팝한다 
						stack.pop();
					}
				}
			}
			// 입력의 끝에 스택이 비어 있지 않다면 오류를 출력한다 
			if (!stack.empty()) {
				answer = "NO";
			}
			System.out.println(answer);
		}
		
	}
}
