import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1261 {

    static int N, M;
    static boolean[][] visited;
    static int[][] inputArr;
    static int[][] breakWallCntArr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로 M,  세로 N
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        breakWallCntArr = new int[N][M];
        inputArr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                inputArr[i][j] = line.charAt(j);
            }
        }

        LinkedList<Point> qu = new LinkedList<>();
        qu.offer(new Point(0, 0));
        visited[0][0] = true;
        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                if (nX >= 0 && nX < N && nY >= 0 && nY < M && !visited[nX][nY]) {
                    visited[nX][nY] = true;

                    if (inputArr[nX][nY] == '0') {
                        qu.addFirst(new Point(nX, nY));
                        breakWallCntArr[nX][nY] = breakWallCntArr[p.x][p.y];
                    }else {
                        qu.offer(new Point(nX, nY));
                        breakWallCntArr[nX][nY] = breakWallCntArr[p.x][p.y] + 1;
                    }
                }
            }
        }

        System.out.println(breakWallCntArr[N-1][M-1]);
    }
}
