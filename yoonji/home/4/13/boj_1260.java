import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// DFS와 BFS
// 깊이 우선 탐색. 인접한 노드들의 가장 깊이 연결된 노드까지 탐색하여 돌아오는 방식
// 너비 우선 탐색 : 가장 인접한 노드들을 먼저 방문한 뒤, 그 노드들의 인접 노드들을 방문하는 것을 반복하는 방식
public class boj_1260{
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int nodeNum, startNode;
    public static void main(String[] args) throws IOException {
        // 1. 입력받고 인접 리스트 생성
        input();
        // 2. dfs 수행
        visited = new boolean[nodeNum+1];
        dfs_recursion(startNode);
        System.out.println(sb); sb.setLength(0);
        // 3.  bfs 수행
        visited = new boolean[nodeNum+1];  // 초기화
        bfs(startNode);
        System.out.println(sb);
    }

    static BufferedReader br;
    static LinkedList<Integer>[] adj;
    private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeNum = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        // 각 배열의 리스트 초기화 (노드는 1부터 시작)
        adj = new LinkedList[nodeNum+1];  // 최대 N개 크기
        for (int i=1; i<nodeNum+1; i++) {
            adj[i] = new LinkedList<>();
        }
        makeAdjGraph(M);
    }
    private static void makeAdjGraph(int edgeLen) throws IOException {
        for (int i=0; i<edgeLen; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            // 양방향
            adj[nodeA].add(nodeB);
            adj[nodeB].add(nodeA);
        }
        for (int i=1; i<nodeNum+1; i++) {
            // 크기 오름차순으로 sort
            Collections.sort(adj[i]);
        }
    }

    private static void dfs_recursion(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        Iterator<Integer> listIter = adj[node].listIterator();//LinkedList에 대한 iterator 생성
        while (listIter.hasNext()){
            int linkedNode = listIter.next();
            if (!visited[linkedNode]) {
                dfs_recursion(linkedNode);  // 리스트를 static으로 둘수있으면 좋을텐데
            }
        }
    }
    private static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();        // 정점에 연결된 노드들을 먼저 방문하므로 큐
        q.add(startNode);
        visited[startNode] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");    // 방문이자 출력
            for (int i=0; i< adj[node].size(); i++) {
                int tmp = adj[node].get(i);
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    q.add(tmp);     // 방문한 노드의 인접노드들을 탐색하기 위해 큐에 추가
                }
            }
        }
    }
}