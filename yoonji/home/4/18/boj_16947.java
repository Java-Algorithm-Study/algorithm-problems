import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16947 {
    static int N;
    static List<Integer>[] adj;
    static int[] distFromCycle;
    static boolean[] visited;
    static boolean[] isCycle;
    public static void main(String[] args) throws IOException {
        // 1. 준비
        input();
        // 2. 각 역에 대해 순환선(싸이클) 체크 (깊이 우선으로 모든 노드 탐색)
        isCycle = new boolean[N];
        for (int i=0; i<N; i++) {
            if(checkCycle(i, i, i)) break;  // Cycle이면 stop
//            isCycle = new boolean[N];    // 메서드 내에서 false 처리해주므로 리셋X
        }
        // 3. 최소 거리 체크 (인접 노드들의 순환포함 체크 후 거리 지정 및 ++)
        distFromCycle = new int[N];
        for (int i=0; i<N; i++) {
            visited = new boolean[N]; // 매 거리 체크마다 방문 리셋
            // cycle에 포함X 노드 발견 시
            if (!isCycle[i]) distFromCycle[i] = computeDist(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i:distFromCycle) sb.append(i).append(" ");
        System.out.println(sb);
    }

    private static void input() throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i=0; i<N; i++) adj[i] = new ArrayList<>();
        StringTokenizer st;
        // 인접리스트 생성
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int nodeA = Integer.parseInt(st.nextToken())-1;
            int nodeB = Integer.parseInt(st.nextToken())-1;
            adj[nodeA].add(nodeB);
            adj[nodeB].add(nodeA);
        }
    }
    private static boolean checkCycle(int start, int prev, int now) {
        isCycle[now] = true;    // 사이클 체크
        for (int adjNode: adj[now]) { // 연결된 노드에 방문
            // cycle이 아니면
            if (!isCycle[adjNode]) {
                if(checkCycle(start, now, adjNode)) return true;
            } else if (prev != adjNode && start == adjNode) return true;    // 싸이클인데 시작 노드이면 종료
        }
        isCycle[now] = false;        // cycle을 못만나면
        return false;
    }
    // 인접 노드 중 cycle에 포함된 노드 만날때까지 거리++
    private static int computeDist(int now) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(now, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (isCycle[node.num]) return node.dist;
            for (int adjN : adj[node.num]) {
                if (!visited[adjN]) {
                    visited[adjN] = true;
                    q.add(new Node(adjN, node.dist+1)); // 현재 노드의 인접이니까 거리+1
                }
            }
        }
        return 0;
    }
    static class Node {
        private int num;
        private int dist;
        public Node(int n, int d) {
            this.num = n;
            this.dist = d;
        }
    }
}

