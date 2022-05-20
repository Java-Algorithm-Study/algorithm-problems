import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1261 {
    private static int M;
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    public static class Node {
        int x;
        int y;
    
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            int size1 = q.size();
            x = current.x;
            y = current.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0) {
//                    map[nx][ny] = -1;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
            int size2 = q.size();
            
            if (size1 == size2) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
        
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (!visited[nx][ny]) {
                        map[nx][ny] = map[x][y] + 1;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
            
        }
//        System.out.println(Arrays.toString(map[0]));
//        System.out.println(Arrays.toString(map[1]));
//        System.out.println(Arrays.toString(map[2]));
        return map[N - 1][M - 1];
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.println(bfs(0, 0));
//        System.out.println(Arrays.toString(map[1]));
    }
}
