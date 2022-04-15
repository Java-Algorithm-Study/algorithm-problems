import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordinate {
    int x, y;
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Boj_2178 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs() {
        visited[0][0] = true;

        Queue<Coordinate> qu = new LinkedList<>();
        qu.offer(new Coordinate(0, 0));

        while (!qu.isEmpty()) {
            Coordinate point = qu.poll();

            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (newX >= 0 && newX < N && newY >= 0 && newY < M
                        && !visited[newX][newY] && map[newX][newY] == 1) {

                    qu.offer(new Coordinate(newX, newY));
                    visited[newX][newY] = true;

                    map[newX][newY] = map[point.x][point.y] + 1;
                }
            }
        }
    }
}