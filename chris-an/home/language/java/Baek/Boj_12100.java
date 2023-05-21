package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12100 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[][] board;
    static final int fourDirection = 4;

    static void dfs(int depth, int[][] board) {

        if (depth == 5) {
            return;
        }

        // 사방 탐색
        for (int direction  = 0; direction < fourDirection; direction++) {
            int[][] moved = changeThePositionOfNumberBoard(direction, board);
            dfs(depth + 1, moved);
        }
    }

    private static int[][] changeThePositionOfNumberBoard(int direction, int[][] board) {
        int[][] tempBoard = new int[N][N];

        switch (direction) {
            // 북쪽
            case 0 :
                // 위에서 아래로 탐색
                for (int col = 0; col < N; col++) {
                    int beforeValue = -1;
                    int index = 0;
                    for (int row = 0; row < N; row++) {
                        if (board[row][col] == 0) continue; // 빈 칸일 시 pass
                        else {
                            // 이전 값과 동일 했을 시? 값을 합치기(*2)
                            if (beforeValue == board[row][col]) {
                                int calc = board[row][col] * 2;
                                tempBoard[index - 1][col] = calc;
                                max = Math.max(max, calc);
                                beforeValue = -1;
                            // 그게 아닐 시? index 에 맞춰서 값을 넣어줍니다.
                            }else {
                                tempBoard[index++][col] = board[row][col];
                                beforeValue = board[row][col];
                            }
                        }
                    }
                }
                break;
            // 동쪽
            case 1 :
                // 우(오른쪽)에서 좌(왼쪽)으로 탐색
                for (int row = 0; row < N; row++) {
                    int beforeValue = -1;
                    int index = N - 1;
                    for (int col = N - 1; col >= 0; col--) {
                        if (board[row][col] == 0) continue; // 빈 칸일 시 pass
                        else {
                            // 이전 값과 동일 했을 시? 값을 합치기(*2)
                            if (beforeValue == board[row][col]) {
                                int calc = board[row][col] * 2;
                                tempBoard[row][index + 1] = calc;
                                max = Math.max(max, calc);
                                beforeValue = -1;
                            // 그게 아닐 시? index 에 맞춰서 값을 넣어줍니다.
                            }else {
                                tempBoard[row][index--] = board[row][col];
                                beforeValue = board[row][col];
                            }
                        }
                    }
                }
                break;
            // 남쪽
            case 2 :
                // 아래에서 위로 탐색
                for (int col = 0; col < N; col++) {
                    int beforeValue = -1;
                    int index = N - 1;
                    for (int row = N - 1; row >= 0; row--) {
                        if (board[row][col] == 0) continue; // 빈 칸일 시 pass
                        else {
                            // 이전 값과 동일 했을 시? 값을 합치기(*2)
                            if (beforeValue == board[row][col]) {
                                int calc = board[row][col] * 2;
                                tempBoard[index + 1][col] = calc;
                                max = Math.max(max, calc);
                                beforeValue = -1;
                            // 그게 아닐 시? index 에 맞춰서 값을 넣어줍니다.
                            }else {
                                tempBoard[index--][col] = board[row][col];
                                beforeValue = board[row][col];
                            }
                        }
                    }
                }
                break;
            // 서쪽
            case 3 :
                // 좌(왼쪽)에서 우(오른쪽)으로 탐색
                for (int row = 0; row < N; row++) {
                    int beforeValue = -1;
                    int index = 0;
                    for (int col = 0; col < N; col++) {
                        if (board[row][col] == 0) continue; // 빈 칸일 시 pass
                        else {
                            // 이전 값과 동일 했을 시? 값을 합치기(*2)
                            if (beforeValue == board[row][col]) {
                                int calc = board[row][col] * 2;
                                tempBoard[row][index - 1] = calc;
                                max = Math.max(max, calc);
                                beforeValue = -1;
                            // 그게 아닐 시? index 에 맞춰서 값을 넣어줍니다.
                            }else {
                                tempBoard[row][index++] = board[row][col];
                                beforeValue = board[row][col];
                            }
                        }
                    }
                }
                break;
        }
        return tempBoard;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int column = 0; column < N; column++) {
                board[row][column] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[row][column]);
            }
        }

        dfs(0, board);
        System.out.println(max);
    }
}
