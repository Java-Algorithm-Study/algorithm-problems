import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2580 {
    static final int MATRIX_SIZE = 9;
    static int[][] board = new int[MATRIX_SIZE][MATRIX_SIZE];

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < MATRIX_SIZE; row++) {
            for (int column = 0; column < MATRIX_SIZE; column++) {
                sb.append(board[row][column]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // Row(행) 를 확인합니다.
    static boolean isNumberInRow(int number, int row) {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }
    // Col(열) 를 확인합니다.
    static boolean isNumberInColumn(int number, int column) {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    // 3x3 매트릭스 내에 수가 있는지 확인 메서드
    static boolean isNumberIn3By3Matrix(int number, int row, int column) {
        int start3By3MatrixRow = row - (row % 3);
        int start3By3MatrixColumn = column - (column % 3);
        // ex (5,3) 일 경우, (3,3) 으로 변환하는 과정
        for (int i = start3By3MatrixRow; i < start3By3MatrixRow + 3; i++) {
            for (int j = start3By3MatrixColumn; j < start3By3MatrixColumn + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    // 세 조건이 유효한 지 확인하는 메서드
    static boolean isValid(int number, int row, int column) {
        return !isNumberInRow(number, row) &&
                !isNumberInColumn(number, column) &&
                !isNumberIn3By3Matrix(number, row, column);
    }

    // 스도쿠 풀이를 위한 메서드
    static boolean dfs() {
        // 이중 for loop 를 돌면서,
        for (int row = 0; row < MATRIX_SIZE; row++) {
            for (int column = 0; column < MATRIX_SIZE; column++) {

                // 스도쿠 map 에 빈 곳(0)이라면? In
                if (board[row][column] == 0) {
                    for (int i = 1; i <= MATRIX_SIZE; i++) {
                        if (isValid(i, row, column)) { // 세 가지 조건이 true 라면?
                            board[row][column] = i; // 그 타입을 저장
                            if (dfs()) return true;
                            else board[row][column] = 0; // backtracking
                        }
                    }
                    // * 스도쿠를 해결할 수 없음. 따라서 return false.
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MATRIX_SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs();
        printBoard();
    }
}


