package DFSorBFS;

import java.util.LinkedList;
import java.util.Queue;

public class prg_카카오프렌즈컬러링북 {
    private int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private boolean[][] visited;
    private int numberOfArea = 0;
    private int maxSizeOfaArea = 0;
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        // 영역 별로 부르기
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (visited[r][c] || picture[r][c] == 0) continue;
                findAnswer_bfs(r, c, picture);
                numberOfArea++;
            }
        }
        return new int[]{numberOfArea, maxSizeOfaArea};
    }
    private void findAnswer_bfs(int r, int c, int[][] picture) {
        int areaSize = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(r, c));
        areaSize++;
        visited[r][c] = true;

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i=0; i<4; i++) {
                int nxtR = node.row + dir[i][0];
                int nxtC = node.col + dir[i][1];
                if (isOutOfBounds(nxtR, nxtC, picture.length, picture[0].length)) continue;
                if (visited[nxtR][nxtC]) continue;
                if (picture[nxtR][nxtC] != picture[node.row][node.col] || picture[nxtR][nxtC] == 0)  continue;
                que.add(new Node(nxtR, nxtC));
                areaSize++;
                visited[nxtR][nxtC] = true;
            }
        }
        maxSizeOfaArea = Math.max(maxSizeOfaArea, areaSize);
    }
    private boolean isOutOfBounds(int row, int col, int limitR, int limitC) {
        return row<0 || col<0 || row>= limitR || col >= limitC;
    }

    private class Node {
        int row;
        int col;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}