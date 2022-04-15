import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 이분 그래프
// 두 그룹으로 분할했을 시, 각 그룹 내에서 인접하면 안된다.
public class boj_1707 {
    static List<Integer>[] adj;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int CHECKER = 1;    // 인접노드끼리는 다른 값을 갖는다. (1과 -1)
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int testCase = Integer.parseInt(st.nextToken());
        StringBuilder answer = new StringBuilder();
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            makeAdjGraph(N, M);
            answer.append(checkBipartiteGraph(N)).append("\n");
        }
        System.out.println(answer);
    }

    private static String checkBipartiteGraph(int nodeN) {
        boolean[] visited = new boolean[nodeN+1];
        int[] checkAdj = new int[nodeN+1];
        for (int i=1; i<nodeN+1; i++) {
            if (!visited[i]) {
                Queue<Integer> que = new LinkedList<>();
                que.add(i); visited[i] = true;
                checkAdj[i] = CHECKER;
                while(!que.isEmpty()) {
                    Integer node = que.poll();
                    for (int adjNode: adj[node]) {    // 인접 노드들 탐색
                        if (!visited[adjNode]) {
                            que.add(adjNode); visited[adjNode] = true;  // 연결
                            checkAdj[adjNode] = checkAdj[node] * (-1);  //
                        } else {    // 이미 방문한 노드인 경우
                            if (checkAdj[node] == checkAdj[adjNode]) {
                                return "NO";
                            }
                        }
                    }
                }
            }
        }
        return "YES";
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
