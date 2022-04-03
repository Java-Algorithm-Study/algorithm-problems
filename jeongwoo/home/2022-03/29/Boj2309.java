import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [2309] 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 *
 * -아이디어
 * 1. 9개의 숫자가 입력으로 들어온다. 이중에서 7개를 뽑고, 합이 100인지 판단해야 함. -> 조합
 * 2. level == 7 && sum != 100 -> return
 * 3. sum > 100 return
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj2309 {
    private static int[] dwarf = new int[9];
    private static int[] selected = new int[7];
    private static boolean[] visited = new boolean[9];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);
    }

    private static void dfs(int sum, int level) {
        if (level == 7 && sum != 100) {
            return;
        }
        if (sum > 100) {
            return;
        }
        if (level == 7 && sum == 100) {
            Arrays.sort(selected);
            for (int x : selected) {
                sb.append(x).append('\n');
            }
            System.out.print(sb);
            System.exit(0);
        }
        else {
            for (int i = 0; i < dwarf.length; i++) {
                if (visited[i]) {
                    continue;
                }
                sum += dwarf[i];
                selected[level] = dwarf[i];
                visited[i] = true;
                dfs(sum, level + 1);
                visited[i] = false;
                sum -= dwarf[i];
                selected[level] = 0;
            }
        }
    }
}
