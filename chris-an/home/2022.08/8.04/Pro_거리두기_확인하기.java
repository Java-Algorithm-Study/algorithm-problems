import java.util.*;

public class Pro_거리두기_확인하기 {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    final int side = 5;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++){
            answer[i] = searchP(places[i]);
        }

        return answer;
    }

    public int searchP(String[] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == 'P') {
                    if(!bfs(board, i, j)) return 0;
                }
            }
        }
        return 1;
    }

    public boolean isRange(int x, int y) {
        if(x < 0 || y < 0 || x >= side || y >= side) return false;
        return true;
    }

    public boolean bfs(String[] board, int x, int y) {
        Queue<Node> qu = new LinkedList<>();
        boolean[][] visited = new boolean[side][side];
        qu.offer(new Node(x, y));
        visited[x][y] = true;

        while(!qu.isEmpty()) {
            Node current = qu.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                int manhattan = Math.abs(x - nx) + Math.abs(y - ny);

                if(!isRange(nx, ny)) continue;
                if(visited[nx][ny] || manhattan > 2) continue;

                char newV = board[nx].charAt(ny);

                if(newV == 'X' )
                    continue;
                else if(newV == 'P')
                    return false;

                visited[nx][ny] = true;
                qu.offer(new Node(nx, ny));
            }
        }
        return true;
    }

    public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
