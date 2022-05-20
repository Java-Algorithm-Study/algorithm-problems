import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_49189 {
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static int[] distance;
    private static boolean[] visited;
    
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int x : list.get(current)) {
                if (visited[x]) continue;
                q.offer(x);
                visited[x] = true;
                distance[x] = distance[current] + 1;
            }
        }
        
    }
    
    public static int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        int answer = 0;
        for (int i = 0; i <= 6; i++) {
            list.add(new ArrayList<>());
        }
    
        for (int[] node : edge) {
            int u = node[0];
            int v = node[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        bfs();
        Arrays.sort(distance);
        for (int i : distance) {
            if (i == distance[distance.length - 1]) answer++;
        }
        return answer;
    }
    
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edge));
    }
}
