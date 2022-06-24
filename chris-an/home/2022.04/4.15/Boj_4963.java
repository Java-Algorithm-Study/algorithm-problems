import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Coordinate_ {
    int y, x;
    Coordinate_(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Boj_4963 {

    /*
        섬의 개수
     */

    /*
        (-1,-1) (-1, 0) (-1, 1)
        (0, -1) ( 정점 ) (0,  1)
        (1, -1) (1, 0)  (1, 1)
     */

    static int w, h;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean[][] visited;
    static int[][] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 입력의 마지막 줄에는 0이 두 개 주어진다.
            if (w == 0 && h == 0) break;

            // 사이즈에 맞게 일단 영역할당
            map = new int[h][w];
            // map 세팅
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[h][w];
            count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }

                }
            }

            System.out.println(count);
        }
    }

    public static void bfs(int x, int y) {

        visited[x][y] = true;

        Queue<Coordinate_> qu = new LinkedList<>();
        qu.offer(new Coordinate_(x, y));

        while (!qu.isEmpty()) {
            Coordinate_ point = qu.poll();

            for (int i = 0; i < 8; i++) {
                int newX = point.y + dx[i];
                int newY = point.x + dy[i];

                if (newX >= 0 && newX < h && newY >= 0 && newY < w
                        && map[newX][newY] == 1 && !visited[newX][newY]) {
                    qu.offer(new Coordinate_(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }
}
