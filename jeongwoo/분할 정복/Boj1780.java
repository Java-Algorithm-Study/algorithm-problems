import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [1780] 종이의 개수
 * https://www.acmicpc.net/problem/1780
 *
 * -아이디어
 * 1. n * n의 배열에 종이가 들어온다.
 * 2. 들어온 종이가 다 같은 종이라면 종이에 써 있는 숫자가 1장 추가.
 * 3. 다른 숫자가 적혀 있다면 종이를 찢어야 되니까 3으로 나눈다. (배열 사이즈는 3^K로 들어오기 때문에 같은 사이즈로 찢기 위해서 3으로 나눈다.)
 * 4. 찢어진 종이가 다 같은 종이인지 탐색한다 (2번 행위)
 *
 */

public class Boj1780 {
    private static int[] cnt = new int[3];
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndConquer(0, 0, n);

        for (int x : cnt) {
            System.out.println(x);
        }

    }

    private static void divideAndConquer(int row, int col, int length) {
        if (isSamePaper(row, col, length)) {
            cnt[board[row][col] + 1] += 1;
            return;
        }

        int newLen = length / 3;

        divideAndConquer(row, col, newLen);
        divideAndConquer(row, col + newLen, newLen);
        divideAndConquer(row, col + newLen * 2, newLen);

        divideAndConquer(row + newLen, col, newLen);
        divideAndConquer(row + newLen, col + newLen, newLen);
        divideAndConquer(row + newLen, col + newLen * 2, newLen);

        divideAndConquer(row + newLen * 2, col, newLen);
        divideAndConquer(row + newLen * 2, col + newLen, newLen);
        divideAndConquer(row + newLen * 2, col + newLen * 2, newLen);


    }

    private static boolean isSamePaper(int row, int col, int length) {
        int num = board[row][col];

        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (num != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
