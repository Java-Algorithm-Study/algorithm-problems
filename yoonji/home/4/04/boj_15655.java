import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// N과 M (6)
// 조건 : 비내림차순. 한 line에서 중복x
public class boj_15655 {
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
        visited = new boolean[N];   // for 조건(한 line에서 중복x) 수행
        line = new int[limit];
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(0, 0);
        System.out.println(answerSB);
    }

    private static void dfs(int depth, int num) {
        if (depth == limit) {
            for (int i: line) answerSB.append(i).append(" ");
            answerSB.append("\n");
            return;
        }
        for (int i=num; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                line[depth] = nums[i];
                dfs(depth+1, i+1);  // 조건(오름차순) 수행
                visited[i] = false;
            }
        }
    }
}