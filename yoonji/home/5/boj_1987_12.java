import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 알파벳
public class boj_1987_12 {
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int row;
    static int col;
    static List<Character> alpabet = new ArrayList<>();
    static char[][] board;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        init();
        recur(0, 0, 1);
        System.out.println(max);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rowCol = br.readLine().split(" ");
        row = Integer.parseInt(rowCol[0]);
        col = Integer.parseInt(rowCol[1]);
        visited = new boolean[row][col];
        board = new char[row][col];
        for (int i=0; i<row; i++) {
            String line = br.readLine();
            for (int j=0; j<col; j++) board[i][j] = line.charAt(j);
        }
        visited[0][0]=true;
        alpabet.add(board[0][0]);
    }

    private static void recur(int r, int c, int count) {
        for (int i=0; i<dc.length; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if ((nextR<0 || nextR >= row || nextC<0 || nextC >=col) || visited[nextR][nextC] || alpabet.contains(board[nextR][nextC])) {
                max = Math.max(max, count);
                continue;
            }
            visited[nextR][nextC] = true;
            alpabet.add(board[nextR][nextC]);
            recur(nextR, nextC, count + 1);
            visited[nextR][nextC] = false;
            alpabet.remove(alpabet.size() - 1);
        }
    }
}
