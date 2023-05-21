package language.java.Programmers;

public class Pro_N_Queen {
    int result;
    boolean[] colLine;
    boolean[] ldruLine;
    boolean[] lurdLine;

    public void dfs(int row, int n) {
        if(row == n) {
            result++;
            return;
        }

        for (int col = 0; col < n; col++) {
            // 열 탐색
            if(colLine[col]) continue;
            // 좌하우상 탐색
            if(ldruLine[col + row]) continue;
            // 좌상우하 탐색
            if(lurdLine[(row - col) + (n - 1)]) continue;

            colLine[col] = true;
            ldruLine[col + row] = true;
            lurdLine[(row - col) + (n - 1)] = true;

            dfs(row + 1, n);

            colLine[col] = false;
            ldruLine[col + row] = false;
            lurdLine[(row - col) + (n - 1)] = false;
        }
    }

    public int solution(int n) {
        result = 0;
        int range = (n*2)-1;

        colLine = new boolean[n];
        ldruLine = new boolean[range]; //좌하우상
        lurdLine = new boolean[range]; //좌상우하

        dfs(0, n);

        return result;
    }
}