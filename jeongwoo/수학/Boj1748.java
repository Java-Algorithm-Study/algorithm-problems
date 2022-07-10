import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [1748] 수 이어 쓰기 1
 * https://www.acmicpc.net/problem/1748
 *
 * -아이디어
 * 1. n을 입력 받으면 1부터 n까지 숫자 이어 쓰기
 * 2. 1부터 n까지 숫자를 다 입력 받지 말고 자릿수만 계산하면 된다
 * 3. n은 최대 1억이니까 일, 십, 백, 천, 만, 십만, 백만, 천만, 억 자릿수 + 십억 하나
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            // 1의 자리
            if (i >= 1 && i < 10) {
                ans += 1;
            }
            // 10의 자리
            else if (i >= 10 && i < 100) {
                ans += 2;
            }
            //100의 자리
            else if (i >= 100 && i < 1000) {
                ans += 3;
            }
            // 1,000의 자리
            else if (i >= 1000 && i < 10000) {
                ans += 4;
            }
            // 10,000의 자리
            else if (i >= 10000 && i < 100000) {
                ans += 5;
            }
            // 100,000
            else if (i >= 100000 && i < 1000000) {
                ans += 6;
            }
            // 1,000,000
            else if (i >= 1000000 && i < 10000000) {
                ans += 7;
            }
            // 10,000,000
            else if (i >= 10000000 && i < 100000000) {
                ans += 8;
            }
            // 100,000,000
            else {
                ans += 9;
            }
        }
        System.out.println(ans);
    }
}
