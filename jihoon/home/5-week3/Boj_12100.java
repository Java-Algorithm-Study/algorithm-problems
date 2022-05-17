import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12100 {
    private static int N;
    private static int[][] board;
    
    private static int max = -1;
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        System.out.println(max);
    }
    
    public static void dfs(int depth) {
        if (depth == 5) {
            findMax();
            return;
        }
        
        int[][] copy = new int[N][N];
        copyBoard(copy, board);
        
        for (int i = 0; i < 4; i++) {
            move(i);
            dfs(depth + 1);
            copyBoard(board, copy);
        }
    }
    
    public static void copyBoard(int[][] a, int[][] b) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = b[i][j];
            }
        }
    }
    
    public static void move(int dir) {
        switch (dir) {
            //위로 몰기
            case 0:
                for (int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (board[j][i] != 0) {
                            if (block == board[j][i]) {
                                board[index - 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            } else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 1:
                for (int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if (board[j][i] != 0) {
                            if (block == board[j][i]) {
                                board[index + 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            } else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 2:
                for (int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] != 0) {
                            if (block == board[i][j]) {
                                board[i][index - 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            } else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //오른쪽으로 몰기
            case 3:
                for (int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if (board[i][j] != 0) {
                            if (block == board[i][j]) {
                                board[i][index + 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            } else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
    
    public static void findMax() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(board[i][j], max);
            }
        }
    }
    
}
