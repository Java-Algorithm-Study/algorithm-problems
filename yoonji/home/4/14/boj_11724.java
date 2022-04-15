import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연결 요소의 개수
public class boj_11724 {
    static List<Integer>[] adj;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        int connectionCnt=0;
        boolean[] visited = new boolean[N+1];
        for (int i=1; i<N+1; i++) {
            if (!visited[i]) {
                Queue<Integer> que = new LinkedList<>();
                que.add(i); visited[i] = true;
                while(!que.isEmpty()) {
                    Integer node = que.poll();
                    for (int j=0; j<adj[node].size(); j++) {
                        Integer adjNode = adj[node].get(j);
                        if (!visited[adjNode])
                            que.add(adjNode); visited[adjNode] = true;
                    }
                }
                connectionCnt++;
            }
        }
        System.out.println(connectionCnt);
    }
    static int N;
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        makeAdjGraph(N, M);
    }
    private static void makeAdjGraph(int nodeN, int edgeN) throws IOException {
        adj = new LinkedList[nodeN+1];
        for (int i = 1; i < nodeN+1; i++) adj[i] = new LinkedList<>();
        StringTokenizer st;
        for (int i=0; i< edgeN; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            adj[nodeA].add(nodeB);
            adj[nodeB].add(nodeA);
        }
    }
}
