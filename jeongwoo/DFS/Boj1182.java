import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [1182] 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 *
 * -아이디어
 * 1. 입력 받은 arr 내에서 합이 s가 되는 부분 수열을 구한다 -> 조합
 * 2. dfs 메소드 내에서 if (sum == s) {~} else {~} 이렇게 두게 되면 
 * 3. arr 안에 음수도 포함돼 있기 때문에 다른 경우의 수를 없애 버린다..
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj1182 {
    private static int n, s, cnt = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        if (s == 0) {
            cnt--;
        }
        System.out.println(cnt);

    }

    private static void dfs(int level, int start, int sum) {
        if (sum == s) {
            cnt++;
        }

        for (int i = start; i < n; i++) {
            dfs(level + 1, i + 1, sum + arr[i]);
        }

    }
}
