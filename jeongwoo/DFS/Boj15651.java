import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [15651] N과 M (3)
 * https://www.acmicpc.net/problem/15651
 *
 * -아이디어
 * 1. 중복 허용하고, 순서 상관있음 -> 중복 순열
 *
 * -시간 복잡도
 * 1. O(N^M)
 *
 * -자료 구조
 * 1.
 */

public class Boj15651 {
    private static int n, m;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];
        dfs(0);
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
            for (int i = 1; i <= n; i++) {
                nums[level] = i;
                dfs(level + 1);
            }

        }
    }

}
