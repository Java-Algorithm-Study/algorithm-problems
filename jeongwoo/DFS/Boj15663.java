import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [15663] N과 M (9)
 * https://www.acmicpc.net/problem/15663
 *
 * -아이디어
 * 1. N개의 자연 수 중에서 M개를 고른 수열 -> 중복되는 수열 여러 번 출력 X 사전순 증가
 * 2. 9, 7, 9, 1인 경우 (1, 7) (1, 9) .. (9, 9) < 이건 됨.
 * 3. 입력 배열 안에 중복된 숫자가 있는 경우 중복으로 뽑을 수는 있지만 (1, 9) (1, 9) 같은 수열은 출력하면 안 된다.
 * 4. HashMap은 key : value여서 key가 중복되면 안 돼서 HashSet<String>으로 뽑은 수열을 넣는다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj15663 {
    private static int n, m;
    private static int[] nums;
    private static int[] input;
    private static boolean[] visited;
    private static HashSet<String> hashSet;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        input = new int[n];
        nums = new int[m];
        hashSet = new LinkedHashSet<>();

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
            StringBuilder tempSb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                tempSb.append(nums[i]).append(' ');
            }
            if (!hashSet.contains(tempSb.toString())) {
                sb.append(tempSb).append('\n');
                hashSet.add(tempSb.toString());
            }
        }
        else {
            for (int i = 0; i < input.length ; i++) {
                if (visited[i]) {
                    continue;
                }

                nums[level] = input[i];
                visited[i] = true;
                dfs(level + 1);
                nums[level] = 0;
                visited[i] = false;
            }
        }
    }
}
