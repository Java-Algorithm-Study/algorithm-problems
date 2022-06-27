import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [15650] N과 M (2)
 * https://www.acmicpc.net/problem/15650
 *
 * -아이디어
 * 1. 1부터 N까지 자연수 중에서 중복 없이 M개 고른 수열, 오름차순 -> 중복 없이 m개 고르기 : 조합
 * 2. 앞에 나온 수보다 커야 됨.
 * 3. 중복 체크 대신 for문에서 nums를 앞보다 크게 한다.
 * 4. dfs(0) i = 3일 때 dfs(1)에서 i는 4부터 시작해야 한다.
 * 5. i값을 dfs를 통해 넘겨서 i+1부터 시작하게 한다.
 *
 *
 * -시간 복잡도
 * 1. O(nCm)
 *
 * -자료 구조
 * 1.
 */

public class Boj15650 {
    private static int n, m;
    private static int[] nums;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];
        visited = new boolean[n+1];

        dfs(1, 0);
        System.out.println(sb);
    }

    private static void dfs(int start, int level) {
        if (level == m) {
            for (int i = 0; i < m; i++) {
                sb.append(nums[i]).append(' ');
            }
            sb.append('\n');
        }
        else {
            for (int i = start; i <= n; i++) {
                nums[level] = i;
                dfs(i + 1,level + 1);
                nums[level] = 0;
            }
        }
    }
}
