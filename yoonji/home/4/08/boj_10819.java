import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 차이를 최대로
public class boj_10819 {
    private static int max = Integer.MIN_VALUE;
    private static int sum = 0;
    private static int[] line;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        line = new int[N];
        dfs(0, N, nums);
        System.out.println(max);
    }

    public static void dfs(int depth, int N, int[] nums) {
        if (depth == N) {
            int sum = 0;
            for (int i=0; i<N-1; i++) sum+= Math.abs(line[i] - line[i+1]);  // 차이의 절댓값
            max = Math.max(max, sum);   // 최댓값
        }
        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                line[depth] = nums[i];
                dfs(depth+1, N, nums);
                visited[i] = false;
            }
        }
    }
}
