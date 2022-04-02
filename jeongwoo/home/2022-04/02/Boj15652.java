import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [15652] N과 M (4)
 * https://www.acmicpc.net/problem/15652
 *
 * -아이디어
 * 1. 중복 허용, 비내림차순
 * 2. 다음에 저장되는 숫자는 앞자리 숫자보다 크거나 같아야 된다.
 * 3. 이번에 저장되는 배열의 인덱스보다 하나 앞에 있는 인덱스에 있는 숫자를 start로 보낸다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj15652 {
    private static int n, m;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];

        dfs(1,0);
        System.out.println(sb);
    }

    private static void dfs(int start, int level) {
        if (level == m) {
            for (int x : nums) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        }
        else {
            for (int i = start; i <= n; i++) {
                nums[level] = i;
                dfs(i,level + 1);
            }
        }
    }
}
