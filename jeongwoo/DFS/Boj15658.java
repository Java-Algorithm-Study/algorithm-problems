import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [15658] 연산자 끼워넣기 2
 * https://www.acmicpc.net/problem/15658
 *
 * -아이디어
 * 1. N개의 숫자와 N-1보다 크거나 같고, 4N보다는 작은 연산자가 입력으로 들어온다.
 * 2. 연산자를 중복 없이 n-1개를 뽑아서 순서 상관 있게 나열한다. -> 순열
 * 3. 연산 결과값을 최대, 최소를 비교하여 저장한다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj15658 {
    private static int n;
    private static int[] nums, operator;
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int level, int sum) {
        if (level == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                switch(i) {
                    case 0:
                        ans = sum + nums[level];
                        break;

                    case 1:
                        ans = sum - nums[level];
                        break;

                    case 2:
                        ans = sum * nums[level];
                        break;

                    case 3:
                        ans = sum / nums[level];
                        break;
                }
                dfs(level + 1, ans);
                operator[i]++;
            }
        }
    }
}
