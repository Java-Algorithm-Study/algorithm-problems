import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (5) : 1~N이 아닌 N개의 수를 제공
// 조건 : 중가순, 중복 X => visited 배열 사용
public class boj_15654 {
    private static int N, limit;
    private static int[] line, nums;
    private static boolean[] visited;
    private static final StringBuilder answerSB = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        nums = new int[N];
        visited = new boolean[N];
        line = new int[limit];
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(0);
        System.out.println(answerSB);
    }

    private static void dfs(int depth) {
        if (depth == limit) {
            for (int i:line) {
                answerSB.append(i).append(" ");
            }
            answerSB.append("\n");
            return;
        }
        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                line[depth] = nums[i];
                dfs(depth+1);   // 수는 깊이와 반복문에 따라 자동으로 처리됨
                visited[i] = false; // 한 배열을 채웠으니
            }
        }
    }
}
