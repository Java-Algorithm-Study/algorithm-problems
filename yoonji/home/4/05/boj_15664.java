import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 순서가 있어야하고 중복이 발생하면 안된다
// 수정: 순서는 Arrays.sort()로 해결하므로 중복 제거&들어간대로 쌓이는 LinkedHashSet을 사용한다.
// N과 M(10)
public class boj_15664 {
    private static int N, limit;
    private static int[] nums;
    private static int[] line;
    private static boolean[] visited;
    private static Set<String> setNums = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        visited = new boolean[N];   // for 조건(한 line에서 중복x) 수행
        line = new int[limit];

        st = new StringTokenizer(br.readLine(), " ");
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0, 0);
        StringBuilder answerSB = new StringBuilder();
        for (String line : setNums)
             answerSB.append(line).append("\n");
        System.out.println(answerSB);
    }
    private static StringBuilder tmp = new StringBuilder();
    private static void dfs(int depth, int idx) {
        if (depth == limit) {
            for (int i: line) tmp.append(i).append(" ");
            setNums.add(tmp.toString());
            tmp.setLength(0);
            return;
        }
        for (int i=idx; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                line[depth] = nums[i];
                dfs(depth + 1, i+1);
                visited[i] = false;
            }
        }
    }
}
