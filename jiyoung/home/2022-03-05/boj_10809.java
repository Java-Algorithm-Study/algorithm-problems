import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class boj_10809 {

	public static void main(String[] args) throws IOException {
		boj_10809 boj_10809 = new boj_10809();
		boj_10809.test1();
//		boj_10809.test2(); // indexOf() 사용
	}
	
	static void test1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(arr[ch - 'a'] == -1) {
				// arr 원소 값이 -1인 경우에만 초기화
				arr[ch - 'a'] = i;
			}
		}
		
		for(int val : arr) {
			// 배열 출력
			System.out.print(val + " ");
		}
	}
	
	/**
	 * indexOf()
	 * : 해당 문자가 처음으로 등장하는 위치를 리턴, 
	 *   만약 해당 문자가 없으면 -1을 리턴한다.
	 */
	static void test2() {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		for(char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println(input.indexOf(ch) + " ");
		}
 	}
}
