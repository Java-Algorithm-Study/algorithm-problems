

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11005 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (N != 0) {
            // 아스키코드 변환이 필요할 시,
            if (N % B > 9) sb.append((char) ((N % B) + '7')); // A(65) => (숫자)10 + '7(55)'
                                                            // B(66) => (숫자)11 + '7(55)'
                                                            // Z(90) => (숫자)35 + '7(55)''
                // 아스키코드로 변환이 아닐 시,
            else sb.append(N % B);
            N /= B;
        }
        System.out.println(sb);
    }
}
