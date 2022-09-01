public class Pro_가장큰정사각형찾기 {
    public int solution(int [][]board) {
        int side = 0;
        boolean flag = false;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    flag = true;
                    board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
                    side = Math.max(side, board[i][j]);
                }
            }
        }
        return !flag && board[0][0] == 1 ? 1 : side * side;
    }
}