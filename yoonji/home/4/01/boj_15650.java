import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (2)
// 오름차순으로 탐색하면 되므로 중복을 피하기위해 사용하는 visited는 필요 X
// 오름차순 증가를 위해 dfs 내의 for문은 현재 수부터 탐색하도록하여 +1된 값을 dfs로 호출한다.
// depth가 채워지기전에 N을 넘어서 반복문이 끝나 자동으로 걸러진다.
public class boj_15650 {
    static StringBuilder sb = new StringBuilder();
    static int[] line;
    static int N, limit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        line = new int[limit];
        dfs(0, 1);
        System.out.println(sb);
    }

    private static void dfs(int depth, int now) {
        if (depth == limit) {
            for (int n : line) sb.append(n).append(" ");
            sb.append("\n");
            return;
        }
        for (int i=now; i<= N; i++) {
            line[depth] = i;
            dfs(depth + 1, i + 1);    // 현재 값보다 1 큰 값부터 탐색하도록 재귀호출
        }
    }
}
