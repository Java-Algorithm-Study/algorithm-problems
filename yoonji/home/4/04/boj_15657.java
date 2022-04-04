import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// N과 M (8)
// 조건 : 중복 o, 비내림차순
public class boj_15657 {
    private static int N, limit;
    private static int[] line, nums;
    private static final StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        nums = new int[N];
        line = new int[limit];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(0, 0);
        System.out.println(answerSB);
    }

    private static void dfs(int depth, int idx) {
        if (depth == limit) {
            for (int i: line) answerSB.append(i).append(" ");
            answerSB.append("\n");
            return;
        }
        for (int i=idx; i<N; i++) {
            line[depth] = nums[i];
            dfs(depth+1, i);  // 조건(비내림차순) 수행
        }
    }
}