import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16948 {
    private static int N;
    private static int[][] board;
    private static final int[] dr = {-2, -2, 0, 0, 2, 2};
    private static final int[] dc = {-1, 1, -2, 2, -1, 1};
    
    private static class Night {
        int r;
        int c;
    
        public Night(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static int bfs(int r1, int c1, int r2, int c2) {
        Queue<Night> q = new LinkedList<>();
        q.offer(new Night(r1, c1));
    
        while (!q.isEmpty()) {
            Night current = q.poll();
            int r = current.r;
            int c = current.c;
            for (int i = 0; i < 6; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (board[nr][nc] == 0) {
                    board[nr][nc] = board[r][c] + 1;
                    q.offer(new Night(nr, nc));
                }
            }
        }
        
        return board[r2][c2];
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        var st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int answer = bfs(r1, c1, r2, c2);
        if (answer == 0) System.out.println(-1);
        else System.out.println(answer);
    }
}
