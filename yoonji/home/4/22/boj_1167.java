import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 지름
// 트리의 지름을 구하는 방법
//1. 가장 긴 길이를 갖고있는 정점을 구한다.
//2. 가장 긴 길이의 정점을 기준으로 다시 거리를 측정한다.
//3. 거리를 저장한 배열 중 최대값이 트리의 지름이다.
public class boj_1167 {
    static List<Relation>[] tree;
    static boolean[] visited;
    static class Relation {
        private int to;
        private int weight;
        public Relation(int node, int dist) {
            this.to = node;
            this.weight = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        tree = new List[V+1];
        for (int i = 1; i <= V; i++) tree[i] = new ArrayList<>();
        for (int i=0; i<V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            while(true) {
                int dest = Integer.parseInt(st.nextToken());
                if (dest == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                tree[node].add(new Relation(dest, dist));
            }
        }
        // 2. 지름 찾기
        visited = new boolean[V+1];
        visited[1] = true;
        dfs(1, 0);  // 1에서 시작, 가중치 0
        visited = new boolean[V+1];
        visited[lastNode] = true;
        dfs(lastNode, 0);   // 가장 멀리 있는 노드에서 시작, 가중치 0
        System.out.println(maxWeight);
    }
    static int maxWeight = 0;
    static int lastNode;
    private static void dfs(int node, int weight) {
        if (weight > maxWeight) {
            maxWeight = weight;
            lastNode = node;
        }
        for (Relation adj: tree[node]) {
            if (!visited[adj.to]) {
                visited[adj.to] = true;
                dfs(adj.to, weight+adj.weight); // 가중치++
            }
        }
    }
}