import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [15649] N과 M (1)
 * https://www.acmicpc.net/problem/15649
 *
 * -아이디어
 * 1. 중복 X, 순서 상관 O -> 순열
 * 2. 1부터 N까지 자연수 중에서 중복 없이 M개 고르기
 * 3. 중복이 없어야 되니까 사용한 숫자는 visited[]로 체크해야 된다.
 *
 * -시간 복잡도
 * 1. O(nPm)
 *
 * -자료 구조
 * 1.
 */

public class Boj15649 {
    private static int n, m;
    private static int[] nums;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        nums = new int[m];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int level) {
        if (level == m) {
            for (int i = 0; i < m; i++) {
                sb.append(nums[i]).append(' ');
            }
            sb.append('\n');
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                nums[level] = i;
                dfs(level + 1);
                visited[i] = false;
            }
        }
    }
}
