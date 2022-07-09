import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [15654] N과 M (5)
 * https://www.acmicpc.net/problem/15654
 *
 * -아이디어
 * 1. 입력 받은 수열에서 M개 고르기, 중복 X, 오름차순
 * 2. 들어온 배열을 오름차순으로 정리한다.
 * 3. 중복 불가니까 한 번 사용한 인덱스는 true 처리한다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj15654 {
    private static int n, m;
    private static int[] nums;
    private static int[] input;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[m];
        input = new int[n];
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

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
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                nums[level] = input[i];
                visited[i] = true;
                dfs(level + 1);
                visited[i] = false;
            }
        }
    }
}
