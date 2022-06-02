public class Pro_행렬테두리회전하기 {
    static int[][] board;

    static int rotatedBoundary(int x1, int y1, int x2, int y2) {
        int pre = board[x1][y1];
        int min = pre;
        int rowSize = x2 - x1;
        int columnSize = y2 - y1;

        for (int i = 0; i <= rowSize; i++) {
            if (x1 + i + 1 > x2) board[x1 + i][y1] = board[x1 + i][y1 + 1];
            else board[x1 + i][y1] = board[x1 + i + 1][y1];
            min = Math.min(min, board[x1 + i][y1]);
        }

        for (int i = 1; i <= columnSize; i++) {
            if (y1 + i + 1 > y2) board[x2][y1 + i] = board[x2 - 1][y1 + i];
            else board[x2][y1 + i] = board[x2][y1 + i + 1];
            min = Math.min(min, board[x2][y1 + i]);
        }

        for (int i = 1; i <= rowSize; i++) {
            if (x1 > x2 - i - 1) board[x2 - i][y2] = board[x1][y2 - 1];
            else board[x2 - i][y2] = board[x2 - i - 1][y2];
            min = Math.min(min, board[x2 - i][y2]);
        }

        for (int i = 1; i < columnSize; i++) {
            board[x1][y2 - i] = board[x1][y2 - i - 1];
            min = Math.min(min, board[x1][y2 - i]);
        }
        board[x1][y1 + 1] = pre;

        return min;
    }

    static void settingBoard (int rows, int columns) {
        int value = 1;
        board = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = value++;
            }
        }
    }

    static public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length]; // return 값 담기

        settingBoard(rows, columns);

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            answer[i] = rotatedBoundary(x1, y1, x2, y2);
        }
        return answer;
    }

    public static void main(String[] args) {
        int row = 6;
        int column = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        //System.out.println(solution(row, column, queries));
        int row2 = 3;
        int column2 = 3;
        int[][] queries2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
        System.out.println(solution(row2, column2, queries2));
    }
}
