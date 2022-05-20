import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2667 {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static ArrayList<Integer> houses = new ArrayList<>();
    
    private static class Node {
        private int x;
        private int y;
    
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void bfs(int x, int y) {
        int house = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node current = q.poll();
            x = current.x;
            y = current.y;
    
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 배열 크기 벗어나는 경우 무시
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                // 이미 방문했던 경로면 무시
                if (visited[nx][ny]) continue;
                // 단지가 아닐 경우 무시
                if (map[nx][ny] == 0) continue;
                
                q.offer(new Node(nx, ny));
                visited[nx][ny] = true;
                house++;
            }
        }
        houses.add(house);
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs(i , j);
                    count++;
                }
            }
        }
        Collections.sort(houses);
        
        var sb = new StringBuilder();
        sb.append(count).append("\n");
    
        for (int house : houses) {
            sb.append(house).append("\n");
        }
        System.out.println(sb);
    }
}
