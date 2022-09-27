import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * -아이디어
 * 1. 8진수 -> 2진수: 각 자리를 2진수로 변환한다.
 * 2. 변환한 숫자들을 붙여 준다.
 * 3. 맨 앞자리 수가 아닌 경우에, 2진수로 변환한 숫자가 2자리 이하라면 앞에 0을 붙여 준다.
 *
 * -시간 복잡도
 * 1. O(n) 이하
 * 2. n < 333,334
 *
 */

public class Boj1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            String str = Integer.toBinaryString(input.charAt(i) - '0');
            if (str.length() == 2 && i > 0) {
                sb.append("0");
            }
            else if (str.length() == 1 && i > 0) {
                sb.append("00");
            }
            sb.append(str);
        }

        System.out.println(sb.toString());

    }
}
