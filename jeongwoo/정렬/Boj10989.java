import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [10989] 수 정렬하기 3
 * https://www.acmicpc.net/problem/10989
 *
 * -아이디어
 * 1. n개의 숫자를 오름차순 정렬한다.
 *
 */

public class Boj10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input);

        for (int x : input) {
            sb.append(x).append('\n');
        }
        System.out.println(sb);
    }
}
