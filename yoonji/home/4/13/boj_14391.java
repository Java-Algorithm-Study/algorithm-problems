import java.util.*;
import java.io.*;
// 종이 조각
public class boj_14391 {
    static boolean[] visited;
    static int N;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        // input & 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>(); // add 하기 전 초기화
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            adj[row].add(col);
            adj[col].add(row);
        }
        // 시작 노드 모두 탐색해야함
        for (int startNode=0; startNode<N; startNode++) {
            visited = new boolean[N];
            dfs(0, startNode);    // 깊이와 시작 노드
        }
        System.out.println(0);
    }
    static void dfs(int depth, int node) {
        if (depth == 4) {   // 깊이 4라는 것은 친구 5명이 연결된 것.
            System.out.println(1);
            System.exit(0);
        }
        visited[node] = true;
        for (int i=0; i< adj[node].size(); i++) {   // 해당 노드의 연결된 노드까지만 탐색
            int adjNode = adj[node].get(i);
            if (!visited[adjNode]) {
                visited[adjNode] = true;
                dfs(depth+1, adjNode);    // 연결된 친구일 때의 깊이++
                visited[adjNode] = false;
            }
        }
    }
}