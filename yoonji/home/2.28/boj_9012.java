import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9012 {
	private static void solving() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int sum = 0;
		String[] parenthesis;
		// 테스트 케이스만큼 반복
		for (int i = 0; i < T; i++) {
			parenthesis = br.readLine().split("");
			for (String p : parenthesis) {		// "("를 만나면 +1, ")"를 만나면 -1
				if (p.equals("(")) {
					sum += 1;
				}
				else if (p.equals(")")) {
					sum -= 1;
				}
				if (sum < 0) {  // ')'가 더 많은 경우
					System.out.println("NO");
					break;
				}
			}
			if (sum == 0) System.out.println("YES");
			else if (sum > 0) System.out.println("NO");
			sum = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		solving();
	}
}
