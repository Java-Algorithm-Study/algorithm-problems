import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_14225 {
    private static int N;
    private static int[] sequence;
//    private static Set<Integer> set = new HashSet<>();
    private static boolean[] nums = new boolean[2_000_000];
    
    public static void dfs(int start, int depth, int sum) {
        
        if (depth > 0) {
//            set.add(sum);
            nums[sum] = true;
        }
        
        for (int i = start; i < N; i++) {
            sum += sequence[i];
            dfs(i + 1, depth + 1, sum);
            sum -= sequence[i];
        }
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
    
        int ans = 1;
        while (nums[ans]) {
            ans++;
        }
        System.out.println(ans);
    }
}
