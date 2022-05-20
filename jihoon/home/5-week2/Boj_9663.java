import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Boj_9663 {
    private static int N;
    private static boolean[][] board;
    private static int count;
    
    public static void dfs(int col) {
        if (col == N) {
            count++;
            return;
        }
        boolean[][] copy = new boolean[N][N];
        copyBoard(copy, board);
    
        for (int row = 0; row < N; row++) {
            if (board[row][col]) continue;
            setBoard(row, col);
            dfs(col + 1);
            copyBoard(board, copy);
        }
    }
    
    public static void copyBoard(boolean[][] a, boolean[][] b) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = b[i][j];
            }
        }
    }
    
    public static void setBoard(int row, int col) {
    
        for (int i = col; i < N; i++) {
            board[row][i] = true;
        }
    
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col + 1; j < N; j++) {
                if (Math.abs(i - row) == Math.abs(j - col)) board[i][j] = true;
            }
        }
        
        for (int i = row + 1; i < N; i++) {
            for (int j = col + 1; j < N; j++) {
                if (Math.abs(i - row) == Math.abs(j - col)) board[i][j] = true;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        dfs(0);
        System.out.println(count);
    }
}