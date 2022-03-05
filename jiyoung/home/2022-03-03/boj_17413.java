import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class boj_17413 {

	public static void main(String[] args) throws IOException {
		boj_17413 boj_17413 = new boj_17413();
		boj_17413.bazzyung();
//		boj_17413.boj(); // 백준 알고리즘 강의 코드
	}
	
	static void print(Stack<Character> stk) {
		while(!stk.empty()) {
			System.out.print(stk.peek());
			stk.pop();
		}
	}
	
	static void bazzyung() {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stk = new Stack<>();
		
		String str = sc.nextLine();
		boolean isTag = false;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '<') {
				print(stk); // '<'를 만나면 여태껏 저장해둔 문자열 거꾸로 출력
				isTag = true;
				System.out.print(str.charAt(i));
			} else if(str.charAt(i) == '>') {
				isTag = false;
				System.out.print(str.charAt(i));
			} else if(isTag) {
				System.out.print(str.charAt(i));
			} else {
				if(str.charAt(i) == ' ') {
					print(stk);
					System.out.print(str.charAt(i));
				} else {
					stk.push(str.charAt(i));
				}
 			}
		}
		print(stk);
	}
	
	
	/**
	 * 백준 알고리즘 강의 코드
	 */
	static void printOfBoj(BufferedWriter bw, Stack<Character> s) throws IOException {
		while(!s.isEmpty()) {
			bw.write(s.pop());
		}
	}
	
	static void boj() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean tag = false;
		Stack<Character> s = new Stack<>();
		for(char ch : str.toCharArray()) {
			if(ch == '<') {
				printOfBoj(bw, s);
				tag = true;
				bw.write(ch);
			} else if(ch == '>') {
				tag = false;
				bw.write(ch);
			} else if(tag) {
				bw.write(ch);
			} else {
				if(ch == ' ') {
					printOfBoj(bw, s);
					bw.write(ch);
				} else {
					s.push(ch);
				}
			}
		}
		printOfBoj(bw, s);
		bw.write("\n");
		bw.flush();
	}
	
}
