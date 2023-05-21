package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_16954_2 {
    public static char[][] map = new char[8][8];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0}; // 시계방향
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1, 0};

    public static class CharacterLoc {
        int x;
        int y;

        public CharacterLoc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean bfs() {
        Queue<CharacterLoc> queue = new LinkedList<>();

        boolean[][] visited;
        queue.add(new CharacterLoc(7, 0));

        while (!queue.isEmpty()) {
            int movedInOneTurnCnt = queue.size();
            visited = new boolean[8][8];

            for (int i = 0; i < movedInOneTurnCnt; i++) { // * 이 부분 때문에 초기 로직이 안되서 계속 삽질을 많이 했음.
                CharacterLoc cur = queue.poll();

                if (map[cur.x][cur.y] == '#') continue; // 벽이 내려오면서 걸렸다? pass
                if (cur.x == 0 && cur.y == 7) return true;

                for (int k = 0; k < 9; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];

                    if (!isPossible(nx, ny)) continue;
                    if (visited[nx][ny] || map[nx][ny] == '#') continue;

                    queue.add(new CharacterLoc(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            remapBoard(); // * 위의 movedInOneTurnCnt for 문을 통해서, remapBoard 를 진행한 부분이 중요.
        }
        return false;
    }

    public static void remapBoard() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';

                    if (i != 7) {
                        map[i + 1][j] = '#';
                    }
                }
            }
        }
    }

    static boolean isPossible(int x, int y) {
        return x >= 0 && y >= 0 && x < 8 && y < 8;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) map[i] = br.readLine().toCharArray();
        System.out.println(bfs() ? 1 : 0);
    }
}