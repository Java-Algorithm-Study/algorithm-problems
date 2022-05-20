public class Pro_12905 {
    private static int N;
    private static int[][] map;
    private static int maxArea = Integer.MIN_VALUE;
    
    public static int solution(int[][] board) {
        N = board.length;
        map = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    findLargestSquare(i, j);
                }
            }
        }
        return maxArea;
    }
    
    public static void findLargestSquare(int row, int col) {
        for (int i = 1; i < N; i++) {
            if (possible(row, col, i)) {
                maxArea = Math.max(i * i, maxArea);
            }
        }
    }
    
    private static boolean possible(int row, int col, int length) {
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (i + row >= N || j + col >= N) break;
                if (map[i + row][j + col] == 0) return false;
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution(board));
    }
}
