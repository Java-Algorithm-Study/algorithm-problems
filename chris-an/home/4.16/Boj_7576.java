import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
    1000 x 1000
    맵에 있는 토마토가 최대 100만 개.. 초단위로 100만번씩 돌면 굉장히 비효율적...음

    정수 1은 익은 토마토,
    정수 0은 익지 않은 토마토,
    정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 */

class Coordinate {
    int x, y;
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Boj_7576 {

    /*
        토마토
     */
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1}; // 동 서 남 북
    static int[] dy = {1, -1, 0, 0};
    static int day;
    static Queue<Coordinate> qu = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로 M
        N = Integer.parseInt(st.nextToken()); // 세로 N

        // map 선언 및 초기화 (세팅)
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    qu.offer(new Coordinate(i, j)); // 미리 토마토가 있는 곳(좌표값)을 qu 에 담아 놓는다.
                }
            }
        }
        bfs();
        System.out.println(day);
    }

    private static void bfs() {
        while (!qu.isEmpty()) {
            Coordinate point = qu.poll();

            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && map[newX][newY] == 0) {
                    qu.offer(new Coordinate(newX, newY));
                    map[newX][newY] = map[point.x][point.y] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, map[i][j]);
            }
        }

        day = max - 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    day = -1;
                    break;
                }
            }
        }
    }
}
