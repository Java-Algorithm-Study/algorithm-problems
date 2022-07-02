import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [6603] 로또
 * https://www.acmicpc.net/problem/6603
 *
 * -아이디어
 * 1. n이 주어지면 1 ~ n까지 숫자 중에서 6개를 중복 없이, 순서 상관 없이 선택한다 -> 조합
 * 2. 뽑은 숫자를 오름차순으로 정렬한다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj6603 {
    private static int n;
    private static int[] selected = new int[6];
    private static int[] input;
    private static StringBuilder sb = new StringBuilder();
    private static StringBuilder tempSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            tempSb = new StringBuilder();
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            input = new int[n];
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            tempSb.append(sb);
            System.out.println(tempSb);
        }
    }

    private static void dfs(int start, int level) {
        if (level == 6) {
            for (int i : selected) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }
        else {
            for (int i = start; i < n; i++) {
                selected[level] = input[i];
                dfs(i + 1, level + 1);
            }
        }
    }
}
