import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * [10824] 네 수
 * https://www.acmicpc.net/problem/10824
 */
public class boj_10824 {
	public static void main(String[] args) throws IOException {
		boj_10824 boj_10824 = new boj_10824();
		boj_10824.bazzyung();
//		boj_10824.boj(); // 백준 공유 코드
	}
	
	public void bazzyung() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		long ab = Long.parseLong(input[0] + input[1]);
		long cd = Long.parseLong(input[2] + input[3]);
		
		sb.append(ab + cd);
		System.out.println(sb);
	}
	
	
	/**
	 * 백준 공유 코드
	 */
	public void boj() {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        String A = String.valueOf(a);
        String B = String.valueOf(b);
        String C = String.valueOf(c);
        String D = String.valueOf(d);
        A += B;
        C += D;
        long ans1 = Long.valueOf(A);
        long ans2 = Long.valueOf(C);
        System.out.println(ans1+ans2);
	}
}
