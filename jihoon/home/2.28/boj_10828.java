import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10828 {
	
	int[] stack; // 스택을 담을 배열 선언 
	int pointer = 0; // top값을 가르킬 포인터 선언 
	
	
	// Stack 생성
	boj_10828(int n) {
		this.stack = new int[n]; // 스택배열을 주어진 라인만큼 초기화 
	}
	
	// 스택 배열에 값을 집어넣고 포인터를 1만큼 증가 
	void push(int element) {
		stack[pointer++] = element;
	}
	
	// 스택 배열길이가 0보다 크면 포인터 값을 1만큼 감소시키고 마지막 요소를 리턴 
	int pop() {
		int lastElement = -1;
				
		if (pointer > 0) {
			stack[pointer] = 0;
			lastElement = stack[--pointer];
		} 
		return lastElement;
	}
	
	int size() {
		return pointer;
	}
	
	int empty() {
		if (pointer == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	int top() {
		int lastElement = -1;
		if (pointer > 0) {
			lastElement = stack[pointer - 1];
		}
		return lastElement;
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		boj_10828 stack = new boj_10828(N);

		
		for (int i = 0; i < N; i++) {
			String order = bf.readLine();
			char caseDivider = order.charAt(0);

			if (caseDivider == 'p' && order.length() < 4) {
				System.out.println(stack.pop());
			} else if (caseDivider == 't') {
				System.out.println(stack.top());
			} else if (caseDivider == 's') {
				System.out.println(stack.size());
			} else if (caseDivider == 'e') {
				System.out.println(stack.empty());
			} else {
				int number = Integer.parseInt(order.split(" ")[1]);
				stack.push(number);
			}

		}
		
	}
}