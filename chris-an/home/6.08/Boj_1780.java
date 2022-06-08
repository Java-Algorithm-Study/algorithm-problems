import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1780 {
    static int[][] board;
    static Map<Integer, Integer> result = new HashMap<>(3);

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
        // 재귀를 하면서 탐색도 병행 해야할 거 같음....
        recursiveBoard(N, 0, 0);

        int[] printData = new int[3];
        for (int key : result.keySet()) {
            if (key == -1) printData[0] = result.get(key);
            else if (key == 0) printData[1] = result.get(key);
            else printData[2] = result.get(key);
        }

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

                    // 9곳을 recur 다 돌리기..
                    /**
                     * N = 27 일 경우
                     * 0,0  0,9  0,18
                     * 9,0  9,9  9,18
                     * 18,0 18,9 18,18
                     */
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
        // 통과 됐다는 건? 다 동일하다는 뜻
        result.put(target, result.getOrDefault(target, 0) + 1);
    }
}
