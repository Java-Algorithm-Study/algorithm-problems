import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 모든 순열
// 한 line에서 중복되는 수가 나올 수 없다.
// 1~N까지
public class boj_10974 {
    static int N;
    static int[] line;
    static boolean[] visited;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = new int[N];
        visited = new boolean[N];
        dfs(0);
        System.out.println(answer);
    }
    private static void dfs(int depth) {
        if (depth == N) {
            for (int n: line) answer.append(n).append(" ");
            answer.append("\n");
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                line[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
