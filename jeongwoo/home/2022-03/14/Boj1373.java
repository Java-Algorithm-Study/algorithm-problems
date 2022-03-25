import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [1373] 2진수 8진수
 * https://www.acmicpc.net/problem/1373
 */


/**
 * -아이디어
 * 1. 2진수 -> 8진수 변환 방법: 뒤부터 각 자리에 2^2, 2^1, 2^0 곱한다. 곱한 값들을 세 자리씩 끊는다.
 * 2. 2진수의 길이가 3으로 나누어 떨어지는지 확인한다.
 * 3. 나머지가 0이 아닌 경우 0 or 00을 앞에 붙여 준다.
 * 4. 각 자리에 2^2, 2^1, 2^0을 곱한다.
 * 5. 끊은 값들을 붙인다.
 *
 * -시간 복잡도
 * 1. O(N) 이하
 * 2. n < 1,000,000
 */

public class Boj1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        // 1 3 3
        if (input.length() % 3 == 1) {
            input = "00" + input;
        }

        // 2 3 3
        else if (input.length() % 3 == 2) {
            input = "0" + input;
        }

        for (int i = 0; i < input.length(); i += 3) {
            sb.append((input.charAt(i) - '0') * 4 + (input.charAt(i + 1) - '0') * 2 + (input.charAt(i + 2) - '0'));
        }
        System.out.println(sb.toString());
    }
}
