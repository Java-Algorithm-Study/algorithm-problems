import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206_failed_시간초과 {
    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static Queue<WallLocation> quWall;
    static int min = Integer.MAX_VALUE;
    static final int fourDirection = 4;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean flag;

    static class WallLocation {
        int x;
        int y;

        public WallLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
        int x;
        int y;
        int movedCnt;

        public Node(int x, int y, int movedCnt) {
            this.x = x;
            this.y = y;
            this.movedCnt = movedCnt;
        }
    }

    private static void bfsSetting() {
        char[][] copyBoard = new char[N][M];
        WallLocation wall = quWall.poll();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }
        copyBoard[wall.x][wall.y] = '0';

        bfs(copyBoard);
    }

    private static void bfs(char[][] copyBoard) {
        Queue<Node> quNode = new LinkedList<>();
        visited = new boolean[N][M];

        quNode.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!quNode.isEmpty()) {
            Node point = quNode.poll();

            if (point.x == N-1 && point.y == M-1) {
                min = Math.min(min, point.movedCnt);
                flag = true;
                return;
            }
            for (int i = 0; i < fourDirection; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (copyBoard[nx][ny] == '1') continue;

                visited[nx][ny] = true;
                quNode.offer(new Node(nx, ny, point.movedCnt + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        quWall = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == '1') {
                    quWall.offer(new WallLocation(i, j));
                }
            }
        }

        // 벽을 돌리지 않은 상태에서 bfs 돌리기
        bfs(board);

        // 벽을 한 개 없애고 돌리기
        for (int i = 0; i < quWall.size(); i++) {
            bfsSetting();
        }

        if (flag) System.out.println(min);
        else System.out.println("-1");
    }
}
