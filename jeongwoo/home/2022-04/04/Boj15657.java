import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [15657] N과 M (8)
 * https://www.acmicpc.net/problem/15657
 *
 * -아이디어
 * 1. 입력 받은 수열에서 M개 고르기, 중복 가능, 출력값 비내림차순
 * 2. 들어온 배열을 오름차순으로 정리한다.
 * 3. 중복 가능, 순서 상관있으니까 중복 순열
 * 4. (7, 1)은 안 되니까 for문에서 i를 start(이전에 사용한 배열의 인덱스값)을 넣어 준다.
 * -->
 * 5. nums 배열 앞에 있는 값과 다음에 올 input 배열 값을 비교해서 nums가 크면 continue
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj15657 {
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

        dfs(0, 0);
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
            for (int i = start; i < n; i++) {
                nums[level] = input[i];
                dfs(i, level + 1);
            }
        }

//        else {
//            for (int i = 0; i < n; i++) {
//                if (level != 0 && nums[level-1] > input[i]) {
//                    continue;
//                }
//                nums[level] = input[i];
//                dfs(level + 1);
//            }
//        }
    }
}
