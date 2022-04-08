import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [10974] 모든 순열
 * https://www.acmicpc.net/problem/10974
 *
 * -아이디어
 * 1. 1 ~ N까지의 수로 이루어진 순열을 사전순으로 출력
 * 2. DFS로 visited 체크하면서 접근하기
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj10974 {
    private static int[] arr;
    private static boolean[] visited;
    private static int n;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }


        do {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
        }
        while (nextPermutation(arr));


//        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int level) {
        if (level == n) {
            for (int x : arr) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }
                arr[level] = i;
                visited[i] = true;
                dfs(level + 1);
                arr[level] = 0;
                visited[i] = false;
            }
        }
    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] > arr[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[j] < arr[i - 1]) {
            j--;
        }

        swap(arr, i - 1, j);

        j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
