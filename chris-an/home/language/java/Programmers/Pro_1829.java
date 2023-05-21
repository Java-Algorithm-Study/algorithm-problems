package language.java.Programmers;

import java.util.*;

class Coordinate_Pro_1829 {
    int x; int y;
    Coordinate_Pro_1829(int x, int y) {
        this.x = x; this.y = y;
    }
}

public class Pro_1829 {

    int[] dx = {-1, 0 , 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;

    public int bfs(int m, int n, int x, int y, int[][] picture) {
        int cnt = 1;

        Queue<Coordinate_Pro_1829> qu = new LinkedList<>();
        visited[x][y] = true;
        qu.offer(new Coordinate_Pro_1829(x, y));

        while(!qu.isEmpty()) {
            Coordinate_Pro_1829 point = qu.poll();

            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n
                        && picture[nx][ny] == picture[x][y]
                        && !visited[nx][ny]) {
                    qu.offer(new Coordinate_Pro_1829(nx, ny));
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m, n, i, j, picture));
                    numberOfArea++;
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}