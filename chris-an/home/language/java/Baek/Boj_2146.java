package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordinate_2146 {
    int x;
    int y;

    public Coordinate_2146(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Boj_2146 {

    /*
        [순서]
        1. 각 2차원 배열을 초기화
            1-1. 입력받은 값을 저장해 놓은 배열
            1-2. 섬끼리 비교를 해줘야하니깐, 각 섬마다 고유 정수값을 갖게 배열 생성

        2. BFS 를 통해서 거리 값을 map 에 담기
            2-1. BFS 를 이용하여, 한 이동에 각 섬 주변을 4방면으로 이동하면서 범위를 cnt 해주며 map 에 저장.

        3. 섬과 섬 사이의 최소 거리를 구하기
            3-1. 거리 2차원 배열과 각 섬이 담긴 2차원 배열을 이용하여 최소의 거리를 구합니다.

     */
    static int N;
    static int[][] input; // 입력받은 배열
    static int[][] locateIsland; // 각 섬을 구분하기 위한 배열
    static int[][] interIsland; // 섬과 섬의 거리
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static Queue<Coordinate_2146> qu = new LinkedList<>();
    static int min = Integer.MAX_VALUE;

    private static void searchIsland(int x, int y, int islandNum) {
        Queue<Coordinate_2146> queue = new LinkedList<>();
        queue.offer(new Coordinate_2146(x, y));
        locateIsland[x][y] = islandNum;
        while (!queue.isEmpty()) {
            Coordinate_2146 point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N
                        && input[newX][newY] == 1
                        && locateIsland[newX][newY] == 0) {
                    queue.offer(new Coordinate_2146(newX, newY));
                    locateIsland[newX][newY] = islandNum;
                }
            }
        }
    }

    private static void initDistance() {
        while (!qu.isEmpty()) {
            Coordinate_2146 point = qu.poll();

            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N
                        && interIsland[newX][newY] == -1) {

                    qu.offer(new Coordinate_2146(newX, newY));
                    interIsland[newX][newY] = interIsland[point.x][point.y] + 1;
                    locateIsland[newX][newY] = locateIsland[point.x][point.y];
                }
            }
        }
    }

    private static void searchMinDistance(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < N && newY >= 0 && newY < N
                    && locateIsland[newX][newY] != locateIsland[x][y]) {
                min = Math.min(min, interIsland[newX][newY] + interIsland[x][y]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 입력 받은 섬 위치 Map 초기화
        input = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandNum = 0;
        qu = new LinkedList<>();
        locateIsland = new int[N][N];
        interIsland = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (input[i][j] == 1 && locateIsland[i][j] == 0) {
                    searchIsland(i, j, ++islandNum);
                }

                if (input[i][j] == 1) {
                    interIsland[i][j] = 0; // 섬
                    qu.offer(new Coordinate_2146(i, j));
                } else interIsland[i][j] = -1; // 바다
            }
        }

        initDistance();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                searchMinDistance(i, j);
            }
        }

        System.out.println(min);
    }
}