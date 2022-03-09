import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * [11655] ROT13
 * https://www.acmicpc.net/problem/11655
 */
public class boj_11655 {
	public static void main(String[] args) throws IOException {
		boj_11655 boj_11655 = new boj_11655(); 
		boj_11655.bazzyung();
//		boj_11655.boj(); // 백준 공유 코드
	}
	
	public void bazzyung() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		char[] rot13 = br.readLine().toCharArray();
		
		for(int i = 0; i < rot13.length; i++) {
			if(rot13[i] >= 'A' && rot13[i] <= 'Z') {
				if(rot13[i] >= 'N') {
					rot13[i] -= 13;
				} else {
					rot13[i] += 13;
				}
			} else if(rot13[i] >= 'a' && rot13[i] <= 'z') {
				if(rot13[i] >= 'n') {
					rot13[i] -= 13;
				} else {
					rot13[i] += 13;
				}
			}
		}
		
		for(char i : rot13) {
			sb.append(i);
		}
		
		System.out.println(sb);
	}
	
	
	public void boj() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(rot13(s));
	}
	
	public static String rot13(String s) {
		String ans = "";
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch >= 'a' && ch <= 'm') {
				ch += 13;
			} else if(ch >= 'n' && ch <= 'z') {
				ch -= 13;
			} else if(ch >= 'A' && ch <= 'M') {
				ch += 13;
			} else if(ch >= 'N' && ch <= 'Z' ) {
				ch -= 13;
			}
			
			ans += ch;
		}
		
		return ans;
	}
}
