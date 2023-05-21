package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16236 {
    static int N;
    static int[][] board;
    static Queue<BabyShark> sharkQu = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0}; // 시계방면
    static int[] dy = {0, 1, 0, -1};
    static final int fourDirection = 4;

    static class BabyShark {
        int x;
        int y;
        int sharkLv;
        int eatFeeds;
        int movedSharkCnt;

        public BabyShark(int x, int y, int sharkLv, int eatFeeds, int movedSharkCnt) {
            this.x = x;
            this.y = y;
            this.sharkLv = sharkLv;
            this.eatFeeds = eatFeeds;
            this.movedSharkCnt = movedSharkCnt;
        }
    }

    static void bfs() {
        int movedCnt = 0;

        PriorityQueue<BabyShark> fishQu = new PriorityQueue<>(new Comparator<BabyShark>() {
            @Override
            public int compare(BabyShark o1, BabyShark o2) {
                if (o1.movedSharkCnt == o2.movedSharkCnt) {
                    if (o1.x == o2.x) return o1.y - o2.y;
                    else return o1.x - o2.x;
                }else return o1.movedSharkCnt - o2.movedSharkCnt;
            }
        });

        while (true) {
            boolean[][] visited = new boolean[N][N];
            visited[sharkQu.peek().x][sharkQu.peek().y] = true;

            while (!sharkQu.isEmpty()) {
                BabyShark point = sharkQu.poll();

                for (int d = 0; d < fourDirection; d++) {
                    int nx = point.x + dx[d];
                    int ny = point.y + dy[d];

                    if (!isPossibleRange(nx, ny)) continue;
                    if (board[nx][ny] > point.sharkLv) continue;
                    if (visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    if (point.sharkLv > board[nx][ny] && board[nx][ny] != 0)
                        fishQu.offer(new BabyShark(nx, ny, point.sharkLv, point.eatFeeds + 1, point.movedSharkCnt + 1));
                    else
                        sharkQu.offer(new BabyShark(nx, ny, point.sharkLv, point.eatFeeds, point.movedSharkCnt+ 1));
                }
            }

            if (fishQu.isEmpty()) { System.out.println(movedCnt);
                return;
            }

            BabyShark fish = fishQu.poll();
            //System.out.println(fish.x + " " +fish.y + " : " + fish.movedSharkCnt);
            if (fish.sharkLv == fish.eatFeeds) {
                fish.sharkLv++;
                fish.eatFeeds = 0;
            }
            board[fish.x][fish.y] = 0;
            sharkQu.offer(new BabyShark(fish.x, fish.y, fish.sharkLv, fish.eatFeeds, 0));

            // 갱신
            movedCnt += fish.movedSharkCnt;
            fishQu.clear();
        }
    }

    private static boolean isPossibleRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int column = 0; column < N; column++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 9) {
                    sharkQu.offer(new BabyShark(row, column, 2, 0,0));
                    board[row][column] = 0;
                    continue;
                }
                board[row][column] = temp;
            }
        }

        bfs();
    }
}
