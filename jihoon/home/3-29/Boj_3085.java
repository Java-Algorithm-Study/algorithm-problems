import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_3085 {
    
    // 연속된 사탕 최대갯수 세기
    public static int countRowCol(String[][] board) {
        int maxRow = 1;
        int maxCol = 1;
        for (int i = 0; i < board.length; i++) {
            int rowCount = 1;
            int colCount = 1;
            ArrayList<Integer> rowList = new ArrayList<>();
            ArrayList<Integer> colList = new ArrayList<>();
            for (int j = 1; j < board.length; j++) {
                if (board[i][j].equals(board[i][j - 1])) {
                    rowList.add(++rowCount);
                } else {
                    rowCount = 1;
                }
                
                if (board[j][i].equals(board[j - 1][i])) {
                    colCount++;
                    colList.add(colCount);
                } else {
                    colCount = 1;
                }
            }
            for (int n : rowList) {
                rowCount = Math.max(n, rowCount);
            }
            
            for (int n : colList)
                colCount = Math.max(n, colCount);
            
            maxRow = Math.max(rowCount, maxRow);
            maxCol = Math.max(colCount, maxCol);
        }
        
        return Math.max(maxRow, maxCol);
    }
    
    // 주어진 보드의 인접 행끼리 swap 한다
    public static String[][] swapRow(String[][] board, int i, int j) {
        String temp = board[i][j];
        board[i][j] = board[i][j - 1];
        board[i][j - 1] = temp;
        return board;
    }
    
    // 주어진 보드의 인접 열끼리 swap한다
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
    
        // 행을 swap하며 최대갯수 세기
        int maxRow = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                String[][] rowSwapped = swapRow(board, i, j);
                int countRow = countRowCol(rowSwapped);
                maxRow = Math.max(maxRow, countRow);
                swapRow(board, i, j);
            }
        }
    
        // 열을 swap하며 최대갯수 세기
        int maxCol = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                String[][] colSwapped = swapCol(board, i, j);
                int countCol = countRowCol(colSwapped);
                maxCol = Math.max(maxCol, countCol);
                swapCol(board, i, j);
            }
        }
        
        System.out.println(Math.max(maxRow, maxCol));
    }
}
