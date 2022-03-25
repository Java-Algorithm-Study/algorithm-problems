import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [11005] 진법 변환 2
 * https://www.acmicpc.net/problem/11005
 *
 * -아이디어
 * 1. 주어진 수 N을 B로 몫이 0이 될 때까지 나누고, 나머지를 저장한다.
 * 2. 나머지가 9가 넘어가면 A ~ Z로 바꿔 준다.
 *
 * -시간 복잡도
 * 1. O(N) 이하
 */

public class Boj11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while (n > 0) {
            list.add(n % b);
            n /= b;
        }
        Collections.reverse(list);

        for (int i : list) {
            if (i <= 9) {
                sb.append(i);
            }
            else {
                sb.append((char)(i + 55));
            }
        }

        System.out.println(sb.toString());

    }
}
