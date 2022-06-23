import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971 {
    static int N;
    static int[] arr;
    static int[][] inputDataArr;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;
    static void backTracking(int depth) {

        if (N == depth) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int a = arr[i] - 1;
                int b;

                if (i == arr.length-1) b = arr[0] - 1;
                else b = arr[i + 1] - 1;

                if (inputDataArr[a][b] == 0) return;
                else sum += inputDataArr[a][b];
            }
            minCost = Math.min(minCost, sum);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        inputDataArr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                inputDataArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0);
        System.out.println(minCost);

    }
}