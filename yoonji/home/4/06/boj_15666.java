import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

// N과 M(12)
public class boj_15666 {
    private static int N, limit;
    private static int[] nums;
    private static int[] line;
    private static Set<String> hs = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        line = new int[limit];

        st = new StringTokenizer(br.readLine(), " ");
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0, 0);
        StringBuilder answerSB = new StringBuilder();
        for (String line : hs)
            answerSB.append(line).append("\n");
        System.out.println(answerSB);
    }
    private static StringBuilder tmp = new StringBuilder();
    private static void dfs(int depth, int idx) {
        if (depth == limit) {
            for (int i: line) tmp.append(i).append(" ");
            hs.add(tmp.toString());
            tmp.setLength(0);
            return;
        }
        for (int i=idx; i<N; i++) {
            line[depth] = nums[i];
            dfs(depth + 1, i);
        }
    }
}