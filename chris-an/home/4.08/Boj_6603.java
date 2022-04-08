import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6603 {
    static int[] S;
    static int K;
    static int[] arr;
    static int[] inputDataArr;
    static final int M = 6;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void backTracking(int start, int depth) {

        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = inputDataArr[i];
                backTracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0) break;

            visited = new boolean[K];
            arr = new int[M];
            inputDataArr = new int[K];

            for (int i = 0; i < K; i++) {
                inputDataArr[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0,0);

            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
