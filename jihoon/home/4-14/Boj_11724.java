import java.io.*;
import java.util.*;

public class Boj_11724 {
    private static int N;
    private static int M;
    private static ArrayList<Integer> graph[];
    private static boolean[] visited;
    private static int ans;
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++){
            if (!visited[i]){
                dfs(i);
                ans++;
            }
            
        }
        System.out.println(ans);
        bf.close();
    }
    
    public static void dfs(int current) {
        visited[current] = true;
        for (int next : graph[current]){
            if (!visited[next]){
                dfs(next);
            }
        }
    }
    
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}