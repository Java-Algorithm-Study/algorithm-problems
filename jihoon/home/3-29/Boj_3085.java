import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Boj_3085 {
    
    public static int countRowCol(String[][] board) {
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < board.length; i++) {
            Map<String, Integer> rowMap = new HashMap<>();
            Map<String, Integer> colMap = new HashMap<>();
            for (int j = 0; j < board.length; j++) {
                String rowStr = board[i][j];
                String colStr = board[j][i];
                int rowCount = rowMap.getOrDefault(rowStr, 0);
                int colCount = colMap.getOrDefault(colStr, 0);
                rowMap.put(rowStr, rowCount + 1);
                colMap.put(colStr, colCount + 1);
            }
    
            for (int count : rowMap.values())
                maxRow = Math.max(maxRow, count);
            
            for (int count : colMap.values())
                maxCol = Math.max(maxCol, count);
            
        }
        return Math.max(maxRow, maxCol);
    }
    
    public static String[][] swapRow(String[][] board, int i, int j) {
        String temp = board[i][j];
        board[i][j] = board[i][j - 1];
        board[i][j - 1] = temp;
        return board;
    }
    
    public static String[][] swapCol(String[][] board, int i, int j) {
        String temp = board[j][i];
        board[j][i] = board[j - 1][i];
        board[j - 1][i] = temp;
        return board;
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
    
        // 보드 만들기
        String[][] board = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = line[j];
            }
        }
    
        int maxRow = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                String[][] rowSwapped = swapRow(board, i, j);
                int countRow = countRowCol(rowSwapped);
                maxRow = Math.max(maxRow, countRow);
                swapRow(board, i, j);
            }
        }
    
        int maxCol = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                String[][] colSwapped = swapCol(board, i, j);
                int countCol = countRowCol(colSwapped);
                maxCol = Math.max(maxCol, countCol);
                swapCol(board, i, j);
            }
        }
//        System.out.println(Arrays.toString(board[0]));
//        System.out.println(countRowCol(board));
        System.out.println(Math.max(maxRow, maxCol));
    }
}
