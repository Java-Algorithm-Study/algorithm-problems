import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 순서가 있어야하고 중복이 발생하면 안된다 => SortedSet
// N과 M(9)
public class boj_15663 {
    public static int N, limit;
    public static int[] nums;
    public static int[] line;
    public static boolean[] visited;
    public static SortedSet<String> setNums = new TreeSet<>();

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

        dfs(0);
//        StringBuilder answerSB = new StringBuilder();
        for (String line : setNums) {
            System.out.println(line);
            // answerSB.append(line).append("\n");

        }
//        System.out.println(answerSB);
    }
    private static void dfs(int depth) {
        if (depth == limit) {
            StringBuilder tmp = new StringBuilder();
            for (int i: line) tmp.append(i).append(" ");
            setNums.add(tmp.toString());
            return;
        }
        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                line[depth] = nums[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
