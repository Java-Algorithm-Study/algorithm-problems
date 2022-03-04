import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [10799] 쇠막대기
 * https://www.acmicpc.net/problem/10799
 */

public class Boj10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();
		int answer = 0;
		int bbadda = 0;
		
		char before = ')';
		for (char c : word) {
			if(c == '(') bbadda++;
			else if(before == '(' && c == ')') {
				bbadda--;
				answer += bbadda;
			}
			else {
				bbadda--;
				answer++;
			}
			
			before = c;
		}
		
		System.out.println(answer);
	}

}
