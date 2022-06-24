import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw_오목판정 {
    static Character[][] board;
    static int N;

    static boolean isPossible(int x, int y) {
        int cnt = 0;
        for (int i = 1; i <= 2; i++) {
            // 12시, 6시,
            if (x - i < 0 || x + i >= N) continue;
            if (board[x - i][y] == 'o' && board[x + i][y] == 'o') {
                cnt++;
            }
        }
        if (cnt == 2) return true;


        cnt = 0;
        for (int i = 1; i <= 2; i++) {
            // 1시, 7시,
            if (x - i < 0 || x + i >= N || y + i >= N || y - i < 0) continue;
            if (board[x - i][y + i] == 'o' && board[x + i][y - i] == 'o') {
                cnt++;
            }
        }
        if (cnt == 2) return true;

        cnt = 0;
        for (int i = 1; i <= 2; i++) {
            // 3시, 9시,
            if (y - i < 0 || y + i >= N) continue;
            if (board[x][y + i] == 'o' && board[x][y - i] == 'o') {
                cnt++;
            }
        }
        if (cnt == 2) return true;

        cnt = 0;
        for (int i = 1; i <= 2; i++) {
            // 5시, 11시,
            if (x - i < 0 || x + i >= N || y + i >= N || y - i < 0) continue;
            if (board[x + i][y + i] == 'o' && board[x - i][y - i] == 'o') {
                cnt++;
            }
        }
        if (cnt == 2) return true;


        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            board = new Character[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            boolean flag = false;
            String result = "NO";
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 'o') {
                        if (isPossible(i, j)) {
                            flag = true;
                            result = "YES";
                            break;
                        }
                    }
                }
                if (flag) break;
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
