import java.util.*;

public class Pro_게임맵최단거리 {
    static int row, col;
    static class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public boolean isThisValidRange(int x, int y) {
        if(x < 0 || y < 0 || x >= row || y >= col)
            return false;
        else
            return true;
    }

    public int bfs(int[][] maps) {
        boolean[][] visited = new boolean[row][col];
        Queue<Point> qu = new LinkedList<>();
        visited[0][0] = true;
        qu.offer(new Point(0, 0, 1));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!qu.isEmpty()) {
            Point curPoint = qu.poll();
            if(curPoint.x == row-1 && curPoint.y == col-1) {
                return curPoint.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nX = curPoint.x + dx[i];
                int nY = curPoint.y + dy[i];

                if(!isThisValidRange(nX, nY)) continue;
                if(maps[nX][nY] == 0) continue;
                if(visited[nX][nY]) continue;

                visited[nX][nY] = true;
                qu.offer(new Point(nX, nY, curPoint.distance + 1));
            }
        }

        return -1;
    }

    public int solution(int[][] maps) {
        row = maps.length;
        col = maps[0].length;
        return bfs(maps);
    }
}
