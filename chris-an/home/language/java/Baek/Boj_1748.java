package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int lengthCnt = 1;
        int result = 0;
        int breakPoint = 10;
        for (int i = 1; i <= N; i++) {
            if (i == breakPoint) {
                breakPoint = breakPoint * 10; // 10을 곱해줘야 10-> 100-> 1000-> ...자릿수 판별가능
                lengthCnt++;
            }
            result += lengthCnt;
        }
        System.out.println(result);

    }
}
