import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16197 {
    static int N, M; // 세로, 가로
    static char[][] map;
    static Queue<Node> qu;
    static int[] dx = {-1, 0, 1, 0}; // 시계방향으로 북동남서
    static int[] dy = {0, 1, 0, -1};
    static final int fourDirection = 4;

    static class Node {
        int x;
        int y;
        int moveCnt;

        public Node(int x, int y, int moveCnt) {
            this.x = x;
            this.y = y;
            this.moveCnt = moveCnt;
        }
    }

    static int rangeCheck(int x1, int y1, int x2, int y2) {
        int chk = 0;
        if (x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) chk += 1;
        if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) chk += 1;
        return chk;
    }

    static void addCoinPoint(int nx, int ny, Node curCoin) {
        if (map[nx][ny] == '#')
            qu.offer(new Node(curCoin.x, curCoin.y, curCoin.moveCnt + 1));
        else
            qu.offer(new Node(nx, ny, curCoin.moveCnt + 1));
    }

    static int bfs() {
        while (!qu.isEmpty()) {
            Node coin1 = qu.poll();
            Node coin2 = qu.poll();

            if (coin1.moveCnt >= 10) return -1;
            for (int i = 0; i < fourDirection; i++) {
                int nCoin1_x = coin1.x + dx[i];
                int nCoin1_y = coin1.y + dy[i];
                int nCoin2_x = coin2.x + dx[i];
                int nCoin2_y = coin2.y + dy[i];

                // 둘 다 아웃 했을 시?
                int chkNum = rangeCheck(nCoin1_x, nCoin1_y, nCoin2_x, nCoin2_y);
                if (chkNum == 2) continue;
                if (chkNum == 1) return coin1.moveCnt + 1;

                addCoinPoint(nCoin1_x, nCoin1_y, coin1);
                addCoinPoint(nCoin2_x, nCoin2_y, coin2);
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new char[N][M];
        qu = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                map[i][j] = line[j];
                if (line[j] == 'o') {
                    qu.offer(new Node(i, j, 0)); // 동전 위치값 삽입
                }
            }
        }
        int result = bfs();
        System.out.println(result == -1 ? -1 : result);
    }
}
