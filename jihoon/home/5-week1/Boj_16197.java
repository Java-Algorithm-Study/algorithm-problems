import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_16197 {
    private static int N;
    private static int M;
    private static char[][] board;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int minDepth = Integer.MAX_VALUE;
    
    public static class Coin {
        int x;
        int y;
    
        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static boolean checkBoundry(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    
    public static int countDrops(ArrayList<Coin> coins) {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            int x = coins.get(i).x;
            int y = coins.get(i).y;
            if (checkBoundry(x, y)) count++;
        }
        return count;
    }
    
    public static boolean checkWall(ArrayList<Coin> coins) {
        for (int i = 0; i < 2; i++) {
            int x = coins.get(i).x;
            int y = coins.get(i).y;
            if (!checkBoundry(x, y) && board[x][y] == '#') return true;
        }
        return false;
    }
    
    public static void dfs(ArrayList<Coin> coins, int depth) {
        if (depth > 10) return;
        if (countDrops(coins) > 1) return;
        if (checkWall(coins)) return;
        
        if (countDrops(coins) == 1) {
            minDepth = Math.min(minDepth, depth);
            return;
        }
    
        for (int i = 0; i < 4; i++) {
            ArrayList<Coin> nextCoins = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                Coin coin = coins.get(j);
                int nx = coin.x + dx[i];
                int ny = coin.y + dy[i];
                nextCoins.add(new Coin(nx, ny));
            }
            dfs(nextCoins, depth + 1);
        }

    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        
        ArrayList<Coin> coins = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                char status = line[j].charAt(0);
                board[i][j] = status;
                
                if (status == 'o') coins.add(new Coin(i, j));
            }
        }
        
        dfs(coins, 0);
        if(minDepth == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(minDepth);
        }
    }
}