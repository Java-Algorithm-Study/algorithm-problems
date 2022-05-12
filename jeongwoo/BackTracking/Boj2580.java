import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [2580] 스도쿠
 * https://www.acmicpc.net/problem/2580
 *
 * -아이디어
 * 1. 주어진 칸이 0인 경우를 찾는다.
 * 2. 0이 있는 칸과 같은 행, 열, 3x3 박스에 1부터 9까지 넣어 보면서 있는지 확인한다.
 * 3. 다 통과한다면 그 숫자를 넣는다.
 * 4. 스도쿠 규칙에 안 맞는다면 넣은 숫자를 다시 0으로 바꾼다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */


public class Boj2580 {
    private static int[][] map = new int[9][9];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);
    }

    private static void backTracking(int x, int y) {
        if (y == 9) {
            backTracking(x + 1, 0);
            return;
        }

        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }


        if (map[x][y] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (checkRow(x, k) && checkCol(y, k) && checkBox(x, y, k)) {
                    map[x][y] = k;
                    backTracking(x, y + 1);
                }
            }
            map[x][y] = 0;
            return;
        }
        backTracking(x, y + 1);
    }

    private static boolean checkRow(int row, int x) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == x) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int col, int x) {
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == x) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkBox(int row, int col, int x) {
        int rowStart = row - (row % 3);
        int colStart = col - (col % 3);

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (map[i][j] == x) {
                    return false;
                }
            }
        }
        return true;
    }
}
