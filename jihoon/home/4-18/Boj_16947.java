import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16947 {
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static Set<Integer> set = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();
    private static int[] depths;
    private static boolean flag;
    private static boolean[] visited;
    
    public static void dfs(int i, int depth) {
        if (flag) return;
        if (visited[i]) return;
        visited[i] = true;
        depths[i] = depth;
        set.add(i);

        for (int x : list.get(i)) {
            if (flag) return;
            // 간선을 타다가 순환선을 만나면 해당 역까지 거리를 리턴
            if (set.contains(x) && depths[i] - depths[x] > 1) {
                sb.append(depths[x]).append(' ');
                flag = true;
                return;
            }
            dfs(x, depth + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        depths = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            dfs(i, 0);
            flag = false;
            Arrays.fill(visited, false);
            Arrays.fill(depths, 0);
            set.clear();
        }
        System.out.println(sb);
    }
}
