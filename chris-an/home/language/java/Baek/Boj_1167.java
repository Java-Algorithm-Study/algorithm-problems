package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1167 {

    static int V; // 트리의 정점의 개수
    static ArrayList<ArrayList<Node>> nodeList = new ArrayList<>();
    static boolean[] visited;
    static int max, farNode;

    static class Node {
        int data;
        int edge;

        public Node(int data, int edge) {
            this.data = data;
            this.edge = edge;
        }
    }

    static void dfs(int data, int disSum) {
        visited[data] = true;

        // 가장 먼 노드 data 최신화
        if (disSum > max) {
            max = disSum;
            farNode = data;
        }

        // recur
        for (Node childData : nodeList.get(data)) {
            if (!visited[childData.data]) {
                visited[childData.data] = true;
                dfs(childData.data, childData.edge + disSum);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        // list 초기화
        for (int i = 0; i < V + 1; i++) {
            nodeList.add(new ArrayList<>());
        }

        // 노드리스트 초기화
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());

            String tmp;
            while (!(tmp = st.nextToken()).equals("-1")) {
                int data = Integer.parseInt(tmp);
                int edge = Integer.parseInt(st.nextToken());

                nodeList.get(node).add(new Node(data, edge));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);
        visited = new boolean[V + 1];
        dfs(farNode, 0);

        System.out.println(max);
    }
}
