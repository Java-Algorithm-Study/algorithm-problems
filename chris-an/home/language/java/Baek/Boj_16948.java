package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16948 {
    static boolean[][] visited;
    static Queue<DeathNightLoc> qu;
    static int N, r2, c2;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static boolean flag;
    static final int direction = 6;
    static class DeathNightLoc {
        int row;
        int column;
        int moveCnt;

        public DeathNightLoc(int row, int column, int moveCnt) {
            this.row = row;
            this.column = column;
            this.moveCnt = moveCnt;
        }
    }


    private static void bfs() {
        while (!qu.isEmpty()) {
            DeathNightLoc point = qu.poll();

            if (point.row == r2 && point.column == c2) {
                flag = true;
                System.out.println(point.moveCnt);
                return;
            }
            for (int i = 0; i < direction; i++) {
                int nRow = point.row + dx[i];
                int nColumn = point.column + dy[i];

                if (nRow < 0 || nColumn < 0 || nRow >= N || nColumn >= N) continue;
                if (visited[nRow][nColumn]) continue;;

                visited[nRow][nColumn] = true;
                qu.offer(new DeathNightLoc(nRow, nColumn, point.moveCnt + 1));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        qu = new LinkedList<>();
        qu.offer(new DeathNightLoc(r1, c1, 0));
        visited[r1][c1] = true;
        bfs();
        if (!flag) System.out.println(-1);
    }
}
