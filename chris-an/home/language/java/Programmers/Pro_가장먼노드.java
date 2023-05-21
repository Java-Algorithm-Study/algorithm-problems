package language.java.Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_가장먼노드 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    static int max = Integer.MIN_VALUE;

    static public int solution(int n, int[][] edge) {
        int answer = 0;

        init(n, edge);
        bfs();

        for (int i : dist) {
            if (i == max) answer++;
        }
        System.out.println(answer);
        return answer;
    }

    static void bfs() {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(1); //1번 노드로부터
        visited[1] = true;

        while (!qu.isEmpty()) {
            int node = qu.poll();

            for (int adj : graph.get(node)) {
                if (visited[adj]) continue;

                visited[adj] = true;
                qu.offer(adj);
                dist[adj] = dist[node] + 1;
                max = Math.max(max, dist[adj]);
            }
        }
    }

    static void init(int n, int[][] edge) {
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) graph.add(i, new ArrayList<>());

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        solution(n, vertex);
    }
}
