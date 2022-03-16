import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [2745] 진법 변환
 * https://www.acmicpc.net/problem/2745
 *
 * -아이디어
 * 1. N이 문자라면 숫자로 바꾼다.
 * 2. N에 차례대로 B^0, B^1, ..., B^(N.length() - 1)를 곱한다.
 *
 * -시간 복잡도
 * 1. O(B 길이)
 *
 */

public class Boj2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] n = st.nextToken().toCharArray();
        int b = Integer.parseInt(st.nextToken());
        int temp = 0;
        int ans = 0;

        for (int i = 0; i < n.length; i ++) {
            if (Character.isAlphabetic(n[i])) {
                temp = (int) (n[i] - 55);
            }
            else {
                temp = Integer.parseInt(String.valueOf(n[i]));
            }
            ans += temp * Math.pow(b, n.length - i - 1);
        }
        System.out.println(ans);
    }
}
