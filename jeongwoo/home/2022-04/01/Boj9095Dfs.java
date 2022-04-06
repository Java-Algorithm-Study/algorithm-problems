import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [9095] 1, 2, 3 더하기 DFS
 * https://www.acmicpc.net/problem/9095
 *
 * -아이디어
 * 1. 1, 2, 3을 가지고 중복 순열을 구현한다.
 * 2. 합도 같이 보내서 그 합이 n이면 cnt++;
 * 3. sum > n -> return;
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj9095Dfs {
    private static int n;
    private static int cnt;
    private static int[] nums = {1, 2, 3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;
            dfs(0);
            System.out.println(cnt);
        }
    }

    private static void dfs(int sum) {
        if (sum > n) {
            return;
        }
        if (sum == n) {
            cnt++;
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                dfs(sum);
                sum -= nums[i];
            }

        }
    }
}
