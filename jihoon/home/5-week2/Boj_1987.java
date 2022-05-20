import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987 {
    private static int R;
    private static int C;
    private static int[][] board;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static boolean[] visit = new boolean[26];
    private static int ans = 0;
    
    public static void dfs(int x, int y, int count) {
        int current = board[x][y];
        if (visit[current]) {
            ans = Math.max(ans, count);
            return;
        }
        visit[current] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            dfs(nx, ny, count + 1);
        }
        visit[current] = false;
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 0);
        System.out.println(ans);
    }
}
