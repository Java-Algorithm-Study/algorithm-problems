import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [11576] Base Conversion
 * https://www.acmicpc.net/problem/11576
 *
 * -아이디어
 * 1. m개의 A진법 수를 A^0, A^1, ..., A^(n-1) 곱해서 10진수를 구한다.
 * 2. 10진법을 B진법으로 바꾼다. (10진수를 b로 몫이 0이 될 때까지 나눈다.
 *
 * -시간 복잡도
 * 1.
 *
 */

public class Boj11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(String.valueOf(br.readLine()));
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        int[] arr = new int[m];
        int ten = 0;

        // a진수 받고, 10진수로 변환
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ten += arr[i] * Math.pow(a, arr.length - 1 - i);
        }

        // 10진수를 b진수로 변환
        while (ten > 0) {
            list.add(ten % b);
            ten /= b;
        }

        Collections.reverse(list);

        for (int i : list) {
            sb.append(i).append(' ');
        }
        System.out.println(sb.toString());
    }
}
