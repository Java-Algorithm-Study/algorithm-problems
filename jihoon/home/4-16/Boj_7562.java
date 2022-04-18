import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7562 {
    private static int N;
    private static int[][] map;
    private static int x2;
    private static int y2;
    private static final int[] dx = {2, 1, -2, -1, 2, 1, -2, -1};
    private static final int[] dy = {1, 2, 1, 2, -1, -2, -1, -2};
    
    private static class Node {
        private int x;
        private int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }
    
    public static int bfs(int x, int y) {
        if (x == x2 && y == y2) return 0;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 체스판을 넘어간 경우 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                // 해당 노드를 처음 방문하는 경우에만 경로 기록
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        
        // 나이트가 이동하려는 곳까지의 거리 반환
        return map[x2][y2];
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < testCase; i++) {
            N = Integer.parseInt(bf.readLine());
            map = new int[N][N];
            
            var st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(bf.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            
            System.out.println(bfs(x1, y1));
        }
    }
}

