

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2745 {

    /*
        진법 변환
        B진법 수 N이 주어진다.
        이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char [] B = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());

        int sum = 0;
        int p = 0;
        for (int i = B.length-1; i >= 0; i--) {
            int a;
            if (B[i] - '7' > 9) a = B[i]-'7'; // 9보다 클 경우, ex. Z -> 35/ A -> 10 숫자로 변환해준다.
            else a = Integer.parseInt(String.valueOf(B[i])); // 아닐 경우 변환없이 진행
            sum += a * Math.pow(N, p++); // 제곱근은 후치수식을 이용해서 차례대로
        }
        System.out.println(sum);
    }
}
