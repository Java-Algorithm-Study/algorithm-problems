import java.util.Scanner;

public class Boj_9093 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine(); // Enter 제거 
		String[][] strs = new String[N][]; // 각 라인의 문자열과 해당 문자열의 단어들을 담을 2차원 배열 선언 
		
		for (int i = 0; i < N; i++) {
			strs[i] = sc.nextLine().split(" "); // 문자열마다 단어들을 공백으로 구분해 String배열로 저장 
		}
		sc.close();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < strs[i].length; j++) {
				StringBuffer sb = new StringBuffer(strs[i][j]); // Buffer를 사용해 수정이 가능하도록 만듦 
				String reversedStr = sb.reverse().toString(); // Buffer method인 reverse()를 사용해 문자열을 뒤집고 String으로 저장 
				strs[i][j] = reversedStr; // 저장된 단어들을 뒤집은 단어들로 swap
			}
			System.out.println(String.join(" ", strs[i]));
		}

	}

}
