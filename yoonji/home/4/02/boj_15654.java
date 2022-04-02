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
        // 1. 입력 및 초기화
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
        // 2. 정렬 및 dfs 호출
        Arrays.sort(nums);
        dfs(0, 0);
        System.out.println(answerSB);
    }

    private static void dfs(int depth, int num) {
        // 깊이가 끝까지 온 경우
        if (depth == limit) {
            for (int i:line) {
                answerSB.append(i).append(" ");
            }
            answerSB.append("\n");
            return;
        }
        // 0부터 돌면서 이미 방문한 index를 제외하고 재귀호출
        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                line[depth] = nums[i];
                dfs(depth+1, i+1);
                visited[i] = false; // 한 배열을 채웠으니
            }
        }
    }
}
