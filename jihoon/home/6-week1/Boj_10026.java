import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_10026 {
    private static int N;
    private static char[][] board;
    private static boolean[][] visited;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    private static class Node {
        int x;
        int y;
    
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void bfs(int x, int y) {
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
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (board[x][y] == board[nx][ny]) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
    
        // 보드 세팅
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = line[j].charAt(0);
            }
        }
    
        int rgbCount = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    rgbCount++;
                }
            }
        }
    
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'G') board[i][j] = 'R';
            }
        }
        
        int rbCount = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    rbCount++;
                }
            }
        }
        
        System.out.println(rgbCount + " " + rbCount);
    }
}
