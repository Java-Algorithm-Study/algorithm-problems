package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502 {
    static int[][] board;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static final int direction = 4;
    static int max = Integer.MIN_VALUE;
    static Queue<Virus> qu;

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void dfs (int depth) {
        if (depth == 3) {
            bfs(); // 벽을 세웠을 시? bfs 돌리기
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1; // 벽 세움
                    dfs(depth + 1);
                    // backTracking
                    board[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        int[][] copyBoard = new int[N][M];
        for (int i = 0; i < copyBoard.length; i++) {
            System.arraycopy(board[i],0, copyBoard[i],0, board[0].length);
        }

        qu = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 2) {
                    qu.offer(new Virus(i, j)); // 바이러스 세팅
                }
            }
        }

        while (!qu.isEmpty()) {
            Virus virus = qu.poll();

            for (int i = 0; i < direction; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (copyBoard[nx][ny] == 0) {
                    copyBoard[nx][ny] = 2; // 바이러스 퍼트리고,
                    qu.offer(new Virus(nx, ny));
                }
            }
        }

        // max 값 비교 호출
        findUninfectedLab(copyBoard);
    }

    static void findUninfectedLab(int[][] copyBoard) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyBoard[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken()); //세로
        M  = Integer.parseInt(st.nextToken()); //가로

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }
}
