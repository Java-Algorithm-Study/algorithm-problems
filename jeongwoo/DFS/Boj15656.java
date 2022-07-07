import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [15656] N과 M (7)
 * https://www.acmicpc.net/problem/15656
 *
 * -아이디어
 * 1. 입력 받은 수열에서 M개 고르기, 중복 가능, 오름차순
 * 2. 들어온 배열을 오름차순으로 정리한다.
 * 3. 중복 가능, 순서 상관있으니까 중복 순열
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj15656 {
    private static int n, m;
    private static int[] nums;
    private static int[] input;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[m];
        input = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        dfs( 0);
        System.out.println(sb);
    }

    private static void dfs(int level) {
        if (level == m) {
            for (int x : nums) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        }
        else {
            for (int i = 0; i < n; i++) {
                nums[level] = input[i];
                dfs(level + 1);
            }
        }

    }
}
