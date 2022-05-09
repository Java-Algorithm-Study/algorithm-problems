import java.io.*;

public class Boj_9663 {
    static int N;
    static int numOfCase = 0;
    //static boolean[] rowLine;
    static boolean[] colLine;
    static boolean[] diagonal_LDRU; // 좌하우상
    static boolean[] diagonal_LURD; // 좌상우하

    public static void dfs(int row) {
        if (row == N) {
            numOfCase++; // 경우의 수 증가
            return;
        }

        for (int col = 0; col < N; col++) {
            // 방문체크
            //if (rowLine[row] || colLine[col] || diagonal_LDRU[row + col] || diagonal_LURD[row - col + (N - 1)]) continue;
            if (colLine[col] || diagonal_LDRU[row + col] || diagonal_LURD[row - col + (N - 1)]) continue;

            //rowLine[row] = true;
            colLine[col] = true;
            diagonal_LDRU[row + col] = true;
            diagonal_LURD[row - col + (N - 1)] = true;

            dfs( row + 1); // row 증가
            // BackTracing
            //rowLine[row] = false;
            colLine[col] = false;
            diagonal_LDRU[row + col] = false;
            diagonal_LURD[row - col + (N - 1)] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //rowLine = new boolean[N];
        colLine = new boolean[N];
        diagonal_LDRU = new boolean[N * 2 - 1];
        diagonal_LURD = new boolean[N * 2 - 1];

        dfs(0);
        System.out.println(numOfCase);
    }
}