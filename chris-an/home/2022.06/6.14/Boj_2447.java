import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2447 {
    static String[][] board;

    private static void setupBoard(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void takeStarInBoard(int x, int y, int N) {
        // base case
        if (N == 1) {
            board[x][y] = "*";
            return;
        }


        // recur
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;

                int boardSize = N / 3;
                takeStarInBoard(x + (i * boardSize), y + (j * boardSize), boardSize);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new String[N][N];
        setupBoard(N);

        // 별 세팅 (분할 정복 재귀)
        takeStarInBoard(0, 0, N);


        StringBuilder sb = new StringBuilder();
        for (String[] line : board) {
            for (String s : line) {
                sb.append(s);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
