import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [1987] 알파벳
 * https://www.acmicpc.net/problem/1987
 *
 * -아이디어
 * 1. map에 입력을 넣고, map[i][j] - 'A'로 visitied 배열에 index로 접근한다.
 * 2. dfs 시작할 때 처음 위치를 넣고, 받은 위치에 대해서 상우하좌에 방문한다.
 * 3. 상우하좌에 있는 알파벳에 방문하지 않았으면 방문 처리하고 cnt++
 * 
 */

public class Boj1987 {
    private static int r, c;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static boolean[] visitied = new boolean[26];
    private static int max = Integer.MIN_VALUE;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int idx = map[0][0] - 'A';
        visitied[idx] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int row, int col, int cnt) {
        max = Math.max(max, cnt);

        for (int i = 0; i < dir.length; i++) {
            int nx = row + dir[i][0];
            int ny = col + dir[i][1];

            // 범위 체크
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }
            // A = 0, ..., Z = 25번째 인덱스 방문 처리
            int idx = map[nx][ny] - 'A';
            if (visitied[idx]) {
                continue;
            }
            visitied[idx] = true;
            dfs(nx, ny, cnt + 1);
            visitied[idx] = false;
        }
    }
}
