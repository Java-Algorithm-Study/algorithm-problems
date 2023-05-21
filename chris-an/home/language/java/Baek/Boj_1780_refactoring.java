package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780_refactoring {
    static int[][] board;
    static int[] printData = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        // input settings
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        recursiveBoard(N, 0, 0);

        for (int i : printData) {
            System.out.println(i);
        }
    }

    private static void recursiveBoard(int N, int row, int col) {
        int target = board[row][col];

        for (int i = row; i < row + N; i++) {
            for (int j = col; j < col + N; j++) {
                if (board[i][j] != target) {
                    int nN = N / 3;
                    int nRow = (row / 3) * 3;
                    int nCol = (col / 3) * 3;

                    recursiveBoard(nN , nRow + nN * 0, nCol + nN * 0);
                    recursiveBoard(nN , nRow + nN * 0, nCol + nN * 1);
                    recursiveBoard(nN , nRow + nN * 0, nCol + nN * 2);

                    recursiveBoard(nN , nRow + nN * 1, nCol + nN * 0);
                    recursiveBoard(nN , nRow + nN * 1, nCol + nN * 1);
                    recursiveBoard(nN , nRow + nN * 1, nCol + nN * 2);

                    recursiveBoard(nN , nRow + nN * 2, nCol + nN * 0);
                    recursiveBoard(nN , nRow + nN * 2, nCol + nN * 1);
                    recursiveBoard(nN , nRow + nN * 2, nCol + nN * 2);
                    return;
                }
            }
        }
        printData[target + 1]++;
    }
}

