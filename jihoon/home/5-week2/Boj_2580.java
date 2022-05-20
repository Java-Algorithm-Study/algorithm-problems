import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2580 {
    private static int[][] board = new int[9][9];
    private static ArrayList<Integer> rows = new ArrayList<>();
    private static ArrayList<Integer> cols = new ArrayList<>();
    private static int N;
    
    public static void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        
        int col = cols.get(depth);
        int row = rows.get(depth);
        for (int i = 1; i <= 9; i++) {
            if (possiblity(row, col, i)) {
                board[row][col] = i;
                dfs(depth + 1);
            }
        }
        board[row][col] = 0;
    }
    
    public static boolean possiblity(int row, int col, int x) {
        
        // 가로줄 체크
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == x) return false;
        }
        
        // 세로줄 체크
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == x) return false;
        }
        
        // 3x3 정사각형 체크
        int colIdx = findIdx(col);
        int rowIdx = findIdx(row);
        for (int i = rowIdx; i < rowIdx + 3; i++) {
            for (int j = colIdx; j < colIdx + 3; j++) {
                if (board[i][j] == x) return false;
            }
        }
        
        return true;
    }
    
    public static int findIdx(int i) {
        return  3 * (i / 3);
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            var st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                int n = Integer.parseInt(st.nextToken());
                board[i][j] = n;
                if (n == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        N = rows.size();
        dfs(0);
    }
}