import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13023_after {
    
    private static Node[] graph;
    private static boolean[] visited;
    
    private static class Node {
        private int value;
        private Node child;
        
        public Node(int value, Node child) {
            this.value = value;
            this.child = child;
        }
    }
    
    private static boolean dfs(int n, int count) {
        if (count == 4) {
            return true;
        }
        visited[n] = true;
        
        Node node = graph[n];
        while (node != null) {
            if (!visited[node.value]) {
                if (dfs(node.value, count + 1)) {
                    return true;
                }
            }
            node = node.child;
        }
        
        return visited[n] = false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new Node[N];
        visited = new boolean[N];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u] = new Node(v, graph[u]);
            graph[v] = new Node(u, graph[v]);
        }
        
        for (int i = 0; i < N; i++) {
            if (dfs(i, 0)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

}