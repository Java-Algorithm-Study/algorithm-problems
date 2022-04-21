import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 알고스팟
// 상하좌우 이동 가능
// 돌아가야하는 경우에도 벽보다는 방으로 간다.
// 1보다 0으로 가는 것을 우선순위로 둔다. -> 0-1 BFS
public class boj_1261 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int N,M;
    public static void main(String[] args) throws IOException {
        // 1. 초기화 및 그래프(2차원 행렬) 생성
        input();
        // 2. 0-1 BFS (Queue 이용)
        // 상하좌우로 가는데, 0으로 가는 로직을 우선순위로 둔다.
        escapeMaze_bfs();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));   // char => int
            }
        }
    }
    private static void escapeMaze_bfs() {
        LinkedList<int[]> que = new LinkedList<>(); // 데이터가 배열인 큐
        que.offer(new int[]{0, 0, 0});  // x, y, 데이터
        map[0][0] = -1; // 방문처리
        while (!que.isEmpty()) {
            int[] adj = que.poll();
            int nowX = adj[0];
            int nowY = adj[1];
            int crushCnt = adj[2];
            // 중지 조건 (N,M 만나면 중지)
            if (nowX == map.length - 1 && nowY == map[0].length - 1) {
                System.out.println(crushCnt);
                return;
            }
            for (int i = 0; i < dx.length; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                // 0으로 가는 경우 : 우선순위 높은 경우를 리스트의 맨 앞에 넣어줌 => 빨리 진행 O
                if (map[nextX][nextY] == 0) que.addFirst(new int[]{nextX, nextY, crushCnt});
                // 1으로 가는 경우 : 벽 부수기++
                else if (map[nextX][nextY] == 1) que.offer(new int[]{nextX, nextY, crushCnt+1});
                map[nextX][nextY] = -1; // 방문처리
            }
        }
    }
}