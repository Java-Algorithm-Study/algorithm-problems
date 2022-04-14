import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_13023 {
    private static Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    private static int[] ans;
    
    public static void findNeighbors(int node, int vertex, boolean[] visit, int start) {
        if (vertex == 5) {
            System.out.println(1);
            System.exit(0);
        }
        
        if (adjacencyList.get(node) == null || visit[node]) {
            ans[start] = Math.max(ans[start], vertex);
            return;
        }
        
        for (int i = 0; i < adjacencyList.get(node).size(); i++) {
            visit[node] = true;
            findNeighbors(adjacencyList.get(node).get(i), vertex + 1, visit, start);
            visit[node] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
    
        for (int i = 0; i < M; i++) {
            var line = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            adjacencyList.putIfAbsent(a, new ArrayList<>());
            adjacencyList.putIfAbsent(b, new ArrayList<>());
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }
        bf.close();
        
        ans = new int[N];
        for (int key : adjacencyList.keySet()) {
            boolean[] visit = new boolean[N];
            findNeighbors(key, 0, visit, key);
        }
    
        System.out.println(0);
    }
}
