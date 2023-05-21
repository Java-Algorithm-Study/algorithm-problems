package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_10026   {
    static int N;
    static char[][] board, board2;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static final int fourDirection = 4; // 4방면 이동
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, char[][] map) {
        Queue<Node> qu = new LinkedList<>();
        qu.offer(new Node(x, y));
        visited[x][y] = true;


        while (!qu.isEmpty()) {
            Node point = qu.poll();
            for (int i = 0 ; i < fourDirection; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (!isPossibleRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != map[point.x][point.y]) continue;

                visited[nx][ny] = true;
                qu.offer(new Node(nx, ny));
            }
        }
    }

    static boolean isPossibleRange(int nx, int ny) {
        return nx >= 0 && ny >=0 && nx < N && ny < N;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        board2 = new char[N][N];
        visited = new boolean[N][N];
        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int column = 0; column < N; column++) {
                char c = line.charAt(column);
                board[row][column] = c;

                if (c == 'G') board2[row][column] = 'R';
                else board2[row][column] = c;
            }
        }

        int count1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                bfs(i, j, board);
                count1++;
            }
        }

        visited = new boolean[N][N];
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                bfs(i, j, board2);
                count2++;
            }
        }

        System.out.println(count1 + " " + count2);
    }
}
