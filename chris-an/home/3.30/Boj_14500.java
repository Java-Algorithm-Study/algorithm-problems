import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 사방(북->남->서->동)탐색을 하기 위한 배열
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int maxSum; // 구할 최대 값

    private static void dfs(int row, int col, int cnt, int sum) {
        // 최대 4가지까지 탐색한 뒤에는 탈출
        if (cnt == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < dirs.length; i++) {
            // 새로운 좌표를 세팅
            int nr = row + dirs[i][0];
            int nc = col + dirs[i][1];

            // 새로운 좌표가 범위 내에 있고, 미방문일 경우 if문 통과
            if (isIn(nr, nc) && !visited[nr][nc]) {
                // 방문 시도
                visited[nr][nc] = true;
                // cnt + 1 하면서, 탐색할 갯수 확인해주면서, sum 에 방문할 곳의 정수 값 더해주기
                dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
                // 방문 시도 원복
                visited[nr][nc] = false;
            }

        }
    }

    private static int getLast(int row, int col) {

        int base = map[row][col]; // 베이스는 'ㅗ' 모양의 중간 연결부분을 의미
        int cnt = 0; // 4방면 탐색 성공 횟수
        int min = Integer.MAX_VALUE; // 4방면 탐색하면서, 각각의 방면에 있는 정수 값이 가장 작은 걸 담습니다.

        // 중심점을 중심으로 사방 탐색 시작
        for (int i = 0; i < dirs.length; i++) {
            int nr = row + dirs[i][0]; // N
            int nc = col + dirs[i][1]; // M

            // 범위 내에 있다면? if문 통과
            if (isIn(nr, nc)) {
                cnt++;
                base += map[nr][nc];
                min = Math.min(min, map[nr][nc]);
            }
        }
        // 4방면 탐색이 다 성공했다면, 최소값을 빼주기 (이게 best)
        if (cnt == 4) return base - min;
            // 3방면만 성공했다면, 그대로 진행
        else if (cnt == 3) return base;
            // 나머지 경우는 모양 만들기를 실패
        else return -1;
    }


    private static boolean isIn(int nr, int nc) {
        if (0 <= nr && nr < N && 0 <= nc && nc < M) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // row
        M = Integer.parseInt(st.nextToken()); // col

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방문여부
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                maxSum = Math.max(getLast(i , j), maxSum);
                visited[i][j] = false;
            }
        }
        System.out.println(maxSum);
    }
}