import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2606 {
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static int count;
    private static boolean[] visited;
    
    public static void dfs(int i) {
        if (visited[i]) return;
        visited[i] = true;
        count++;
        for (int x : list.get(i)) {
            dfs(x);
        }
    }
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            count++;
            for (int node : list.get(temp)) {
                if (visited[node]) continue;
                q.offer(node);
                visited[node] = true;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
    
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            var st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
//        dfs(1);
        bfs(1);
        System.out.println(count - 1);
    }
}
