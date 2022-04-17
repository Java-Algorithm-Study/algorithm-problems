import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576 {
    private static int M;
    private static int N;
    private static int[][] box;
    private static int day;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    private static class Node {
        private int x;
        private int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void bfs(ArrayList<Integer> x, ArrayList<Integer> y) {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < x.size(); i++) {
            q.offer(new Node(x.get(i), y.get(i)));
        }
    
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x1 = node.x;
            int y1 = node.y;
            day = box[x1][y1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];
                // 박스 범위 넘어갈 때 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                // 빈 박스일 때 무시
                if (box[nx][ny] == -1) continue;
                
                if (box[nx][ny] == 0) {
                    box[nx][ny] = box[x1][y1] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        
        if (checkTomato())
            System.out.println(day - 1);
        else
            System.out.println(-1);
    }
    
    // box 배열에 0이 남아있다면 false, 아니면 true
    static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                if (tomato == 1) {
                    x.add(i);
                    y.add(j);
                }
                box[i][j] = tomato;
            }
        }
        
        bfs(x, y);

    }
}
