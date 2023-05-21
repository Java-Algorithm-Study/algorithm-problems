package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16929 {
    /*
        Two Dots
        사이클을 찾는 문제, 즉 처음시작한 점과, 마지막으로 끝나는 점이 만나서 서클을 이룬다 생각
     */

    static int N, M; // 세로, 가로
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new String[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                int cnt = 0;
                dfs(i, j, cnt, i, j); // (유동시킬 X, 유동시킬 Y, 4개 이상을 위한 cnt, 탐색시작점[고정] X, 탐색시작점[고정] Y)
                if (flag) break;
            }
            if (flag) break;
        }
        System.out.println(flag ? "Yes" : "No");
    }

    private static void dfs(int x, int y, int cnt, int startX, int startY) {
        if (flag) return;
        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX == startX && newY == startY && cnt >= 4) {
                flag = true;
                return;
            }

            if (newX >= 0 && newX < N && newY >= 0 && newY < M
                    && !visited[newX][newY]
                    && map[newX][newY].equals(map[startX][startY])) {
                dfs(newX, newY, cnt, startX, startY);
            }
        }
    }
}
