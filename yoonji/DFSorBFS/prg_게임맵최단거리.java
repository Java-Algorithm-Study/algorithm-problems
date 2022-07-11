package DFSorBFS;

import java.util.LinkedList;
import java.util.Queue;

public class prg_게임맵최단거리 {
    boolean[][] visited;
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];

        int minimumMoveCnt = findMinimum_bfs(maps);
        return minimumMoveCnt;
    }

    // bfs
    private int findMinimum_bfs(int[][] maps) {
        int rowLen = maps.length;
        int colLen = maps[0].length;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0,0,1));
        visited[0][0]=true;

        while (!que.isEmpty()) {
            Node curr = que.poll();
            if (curr.r == rowLen-1 && curr.c == colLen-1) {
                return curr.moveCnt;
            }
            // for문
            for (int i=0; i<dir.length; i++) {
                int nxtRow = curr.r + dir[i][0];
                int nxtCol = curr.c + dir[i][1];
                // 조건
                if (isOutOfBounds(nxtRow, nxtCol, rowLen, colLen)) continue;
                if (maps[nxtRow][nxtCol] == 0) continue;
                if (visited[nxtRow][nxtCol]) continue;
                visited[nxtRow][nxtCol] = true;
                que.add(new Node(nxtRow, nxtCol, curr.moveCnt+1));
            }
        }
        return -1;
    }
    private static class Node {
        int r;
        int c;
        int moveCnt;
        Node (int r, int c, int moveCnt) {
            this.r = r;
            this.c = c;
            this.moveCnt = moveCnt;
        }
    }
    private boolean isOutOfBounds(int r, int c, int limitR, int limitC) {
        return r>=limitR || r<0 || c>=limitC || c<0;
    }
}