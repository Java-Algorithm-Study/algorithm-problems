import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_16954 {
    static char board[][] = new char[8][8];;
    static boolean visited[][][]  = new boolean[8][8][9];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0}; // 시계방향
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1, 0};

    static class CharacterLoc{
        int x;
        int y;
        int downCnt;

        public CharacterLoc(int x, int y, int downCnt) {
            this.x = x;
            this.y = y;
            this.downCnt = downCnt;
        }
    }

    private static void bfs() {
        Queue<CharacterLoc> queue = new LinkedList<>();

        queue.offer(new CharacterLoc(7, 0, 0));
        visited[7][0][0] = true;

        while(!queue.isEmpty()) {
            CharacterLoc point = queue.poll();
            int curX = point.x;
            int curY = point.y;
            int curDownCnt = point.downCnt;

            if(curX == 0 && curY == 7) {
                System.out.println(1);
                return;
            }

            for(int i = 0; i < 9; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                int nDownCnt = Math.min(curDownCnt + 1, 8);

                if(!isPossible(nx, ny)) continue; // 유동 가능한 범위 check

                if(nx - curDownCnt >= 0 && board[nx - curDownCnt][ny] == '#') continue; // 벽이라 pass
                if(nx - curDownCnt - 1 >= 0 && board[nx - curDownCnt - 1][ny] == '#') continue; // 내려오는 벽에 닿아서 pass

                if(visited[nx][ny][nDownCnt]) continue;

                visited[nx][ny][nDownCnt] = true;
                queue.offer(new CharacterLoc(nx, ny, nDownCnt));
            }
        }
        System.out.println(0);
        return;
    }

    static boolean isPossible(int x, int y) {
        return x >= 0 && y >= 0 && x < 8 && y < 8;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) board[i] = br.readLine().toCharArray();
        bfs();
    }
}