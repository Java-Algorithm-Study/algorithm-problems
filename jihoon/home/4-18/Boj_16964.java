import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_16964 {
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static boolean[] visited;
    private static int[] output;
    private static boolean flag;
    private static int index = 1;
    
    public static void dfs(int i) {
        if (flag) return;
        if (visited[i]) return;
        visited[i] = true;
        HashSet<Integer> set = new HashSet<>();
        for (int child : list.get(i)) {
            if (visited[child]) continue;
            set.add(child);
        }
        if (set.size() == 0) return;
        
        if (set.contains(output[index])) {
            dfs(output[index++]);
        } else {
            flag = true;
        }

    }

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        output = new int[N];
    
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N - 1; i++) {
            var st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        var st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            output[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1);
    
        if (flag) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
