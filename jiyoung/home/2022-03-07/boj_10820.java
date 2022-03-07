import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * [10820] 문자열 분석
 * https://www.acmicpc.net/problem/10820
 */
public class boj_10820 {
	public static void main(String[] args) throws IOException {
		boj_10820 boj_10820 = new boj_10820();
		boj_10820.bazzyung();
//		boj_10820.boj(); // 백준 공유 코드
	}
	
	public void bazzyung() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = "";
		
		while((input = br.readLine()) != null) {
			int[] arr = new int[4];
			
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
					arr[0] += 1;
				} else if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
					arr[1] += 1;
				} else if(input.charAt(i) >= '0' && input.charAt(i) <= '9') {
					arr[2] += 1;
				} else if(input.charAt(i) == ' ') {
					arr[3] += 1;
				}
			}
			
			for(int i : arr) {
				bw.write(i + " ");
			}
			bw.write('\n');
			
			bw.flush();
		}
	}
	
	public void boj() {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			int lower = 0;
			int upper = 0;
			int digit = 0;
			int space = 0;
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if('A' <= ch && ch <= 'Z') {
					upper += 1;
				} else if('a' <= ch && ch <= 'z') {
					lower += 1;
				} else if('0' <= ch && ch <= '9') {
					digit += 1;
				} else if(ch == ' ') {
					space += 1;
				}
			}
			System.out.println(lower + " " + upper + " " + digit + " " + space);
		}
	}
}
