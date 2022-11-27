import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj2021 {
    static class Node {
        int to;
        int count;

        public Node(int to, int count) {
            this.to = to;
            this.count = count;
        }
    }

    private static int R;
    private static List<Integer>[] routes, edges;

    public static int solution(String[] subway, int start, int end) {
        R = 1000000;

        routes = new ArrayList[R + 1];
        edges = new ArrayList[R + 1];

        for (int i = 0; i <= R; i++) {
            routes[i] = new ArrayList<>();
        }

        for (int i = 0; i <= R; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < subway.length; i++) {
            String[] str = subway[i].split(" ");
            for (int j = 0; j < str.length; j++) {
                int station = Integer.parseInt(str[j]);
                routes[i].add(station);
                edges[station].add(i);
            }
        }

        return bfs(start, end);
    }

    public static int bfs(int s, int e) {
        boolean[] visitedRoute = new boolean[R + 1];
        boolean[] visitedStation = new boolean[R + 1];

        Queue<Node> q = new LinkedList<>();
        visitedStation[s] = true;

        for (int v : edges[s]) {
            visitedRoute[v] = true;
            q.offer(new Node(v, 0));
        }

        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int v : routes[n.to]) {
                if (v == e) {
                    return n.count;
                }

                if (visitedStation[v]) {
                    continue;
                }
                visitedStation[v] = true;

                for (int nv : edges[v]) {
                    if (visitedRoute[nv]) {
                        continue;
                    }

                    visitedRoute[nv] = true;
                    q.offer(new Node(nv, n.count + 1));
                }
            }
        }

        return -1;
    }
}
