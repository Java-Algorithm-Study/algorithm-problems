import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15651 {

    static boolean[] visited;
    static int N, M;
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        // base case
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }


        // recursive
        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];

        dfs(0);
        System.out.println(sb);

    }
}
