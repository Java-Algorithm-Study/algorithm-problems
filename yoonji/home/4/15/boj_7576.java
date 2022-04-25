import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class boj_7576 {
    static int[][] box;
    static int h,w;
    static final int UNRIPE_TOMATO = 0;
    static final int RIPE_TOMATO = 1;
    static Queue<TomatoPosition> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        input();
        ripeTomato_byBFS();
        System.out.println(checkZeroAndGetDate()-1);    // 처음에 1일부터 시작했으므로
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        w = sToI(st.nextToken());
        h = sToI(st.nextToken());
        box = new int[h][w];
        for (int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<w; j++) {
                box[i][j] = sToI(st.nextToken());
                findRipeTomato(i, j);
            }
        }
    }
    // 익은 토마토를 찾는다.
    private static void findRipeTomato(int x, int y) {
        if (box[x][y] == RIPE_TOMATO)
            que.offer(new TomatoPosition(x, y));
    }
    // 안익은 토마토가 있는지 체크하며, 최소의 소요 기간을 찾는다.
    private static int checkZeroAndGetDate() {
        int takenDate = Integer.MIN_VALUE;
        Loop1:
        for (int i=0; i<h; i++) {
            for (int j = 0; j < w; j++){
                if (box[i][j] == 0) {
                    takenDate = 0;
                    break Loop1;
                }
                takenDate = Math.max(takenDate, box[i][j]);
            }
        }
        return takenDate;
    }
    // 토마토가 익도록 처리한다.
    private static void ripeTomato_byBFS() {
        int[][] dir = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
        while (!que.isEmpty()) {
            TomatoPosition t = que.poll();
            for (int i=0; i<dir[0].length; i++) {
                int nextX = t.x + dir[0][i];
                int nextY = t.y + dir[1][i];
                if (isInBounds(nextX, nextY) && box[nextX][nextY] == UNRIPE_TOMATO) {
                    que.offer(new TomatoPosition(nextX, nextY));
                    box[nextX][nextY] = box[t.x][t.y] + 1;
                }
            }
        }
    }
    private static boolean isInBounds(int x, int y) {
        return x>=0 && x<h && y>=0 && y<w;
    }
    private static int sToI(String str) {
        return Integer.parseInt(str);
    }
    static class TomatoPosition{
        int x;
        int y;
        public TomatoPosition(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}