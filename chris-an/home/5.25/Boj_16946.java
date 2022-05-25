import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16946 {

    static int N, M;
    static int[][] board;
    static final int fourDirection = 4;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer> al;
    static int[][] resultBoard;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        bfsGroupSetting();
        resultBoardSetting();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(resultBoard[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void resultBoardSetting() {
        resultBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    resultBoard[i][j] = calculateBoard(i, j);
                }
            }
        }
    }

    private static int calculateBoard(int x, int y) {
        int sum = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fourDirection; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if (board[nx][ny] != 1) {
                set.add(board[nx][ny]);
            }
        }
        for (int i : set) {
            sum += al.get(i);
        }
        return sum % 10;
    }


    private static void bfsGroupSetting() {
        al = new ArrayList<>();
        al.add(0); al.add(0);

        int groupNum = 2;
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 이동 가능할 시?
                if (board[i][j] == 0) {
                    bfs(groupNum++, i, j);
                }
            }
        }
    }

    private static void bfs(int idx, int x, int y) {
        Queue<Node> qu = new LinkedList<>();
        qu.offer(new Node(x, y));
        board[x][y] = idx;

        int sum = 1;
        while (!qu.isEmpty()) {
            Node point = qu.poll();

            for (int i = 0; i < fourDirection; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (board[nx][ny] == 0) {
                    sum++;
                    board[nx][ny] = idx;
                    qu.offer(new Node(nx, ny));
                }
            }
        }
        al.add(sum);
    }
}

/*
    private static int calculateBoard(int x, int y) {
        int sum = 1;
        List<Integer> copyAl = new ArrayList<>(al);
        for (int i = 0; i < fourDirection; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if (board[nx][ny] != 1) {
                sum += copyAl.get(board[nx][ny]);
                copyAl.set(board[nx][ny], 0);
            }
        }
        return sum % 10;
    }
 */