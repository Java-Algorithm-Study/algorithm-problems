import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10819 {
    static int N;
    static int[] arr;
    static int[] inputDataArr;
    static boolean[] visited;
    static int MAX = 0;

    static void backTracking(int depth) {

        // base case
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(arr[i] - arr[i+1]);
            }
            MAX = Math.max(MAX, sum);
            return;
        }

        // recur
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = inputDataArr[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        inputDataArr = new int[N];
        for (int i = 0; i < N; i++) {
            inputDataArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputDataArr);

        visited = new boolean[N];
        backTracking(0);

        System.out.println(MAX);
    }
}
