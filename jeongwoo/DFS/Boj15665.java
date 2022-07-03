import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * [15665] N과 M (11)
 * https://www.acmicpc.net/problem/15665
 *
 * -아이디어
 * 1. N개의 자연 수 중에서 M개를 고른 수열 -> 중복되는 수열 여러 번 출력 X 같은 수 여러 번 O, 사전순 출력
 * 2. 9, 7, 9, 1인 경우 (1, 1) (1, 7) .. (9, 9) < 이건 됨.
 * 3. 입력 배열 안에 중복된 숫자가 있는 경우 중복으로 뽑을 수는 있지만 (1, 9) (1, 9) 같은 수열은 출력하면 안 된다.
 * 4. HashMap은 key : value여서 key가 중복되면 안 돼서 HashSet<String>으로 뽑은 수열을 넣는다.
 * 5. visited로 확인할 필요 없다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj15665 {
    private static int n, m;
    private static int[] nums;
    private static int[] input;
    private static HashSet<String> hashSet;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        nums = new int[m];
        hashSet = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        dfs(0);
        hashSet.forEach(System.out::println);
    }

    private static void dfs(int level) {
        if (level == m) {
            StringBuilder tempSb = new StringBuilder();
            for (int x : nums) {
                tempSb.append(x).append(' ');
            }
            if (!hashSet.contains(tempSb)) {
                sb.append(tempSb).append('\n');
                hashSet.add(tempSb.toString());
            }
        }
        else {
            for (int i = 0; i < input.length; i++) {
                nums[level] = input[i];
                dfs(level + 1);
            }
        }
    }
}
