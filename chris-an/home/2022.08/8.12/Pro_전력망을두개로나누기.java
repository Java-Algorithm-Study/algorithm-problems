import java.util.*;

public class Pro_전력망을두개로나누기 {
    int[][] matrix;

    public int bfs(int n, int start) {
        int cnt = 1;

        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        qu.add(start);
        visited[start] = true;

        while(!qu.isEmpty()) {
            int cur = qu.poll();

            for(int i = 1; i < n + 1; i++) {
                if(matrix[cur][i] == 1 && !visited[i]) {
                    qu.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }

        return (int)Math.abs(n-2*cnt);
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        matrix = new int[n + 1][n + 1];

        for(int i = 0; i < wires.length; i++) {
            matrix[wires[i][0]][wires[i][1]] = 1;
            matrix[wires[i][1]][wires[i][0]] = 1;
        }

        for(int i = 0; i < wires.length; i++) {
            int st = wires[i][0];
            int end = wires[i][1];

            matrix[st][end] = 0;
            matrix[end][st] = 0;

            answer = Math.min(answer, bfs(n, i + 1));

            matrix[st][end] = 1;
            matrix[end][st] = 1;
        }

        return answer;
    }
}