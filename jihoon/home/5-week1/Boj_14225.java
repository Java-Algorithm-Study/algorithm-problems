import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_14225 {
    private static int N;
    private static int[] sequence;
    private static ArrayList<Integer> temp = new ArrayList<>();
    private static Set<Integer> set = new HashSet<>();
    
    public static void dfs(int start, int depth) {
        
        if (depth > 0) {
            int sum = 0;
            for (int n : temp) {
                sum += n;
            }
            set.add(sum);
        }
        
        for (int i = start; i < N; i++) {
            temp.add(sequence[i]);
            dfs(i + 1, depth + 1);
            temp.remove(temp.size() - 1);
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
        dfs(0, 0);
    
        int ans = 1;
        while (set.contains(ans)) {
            ans++;
        }
        System.out.println(ans);
    }
}
