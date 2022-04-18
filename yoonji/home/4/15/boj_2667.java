import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단지번호붙이기
public class boj_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dirX = {0, 0, 1, -1};
    static int[] dirY = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    private static class Node {
        private int x;
        private int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        inputAndMakeGraph();
        // 2. 각 위치를 탐색하면서 방문하지 않은 "땅"일 경우 인접 섬을 구한다.
        int complexCnt = 0;
        List<Integer> homeCntOfComplex = new ArrayList<>();
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (visited[i][j] || map[i][j] != 1) continue;
                homeCntOfComplex.add(connectOneComplex(i, j));
                complexCnt++;
            }
        }
        answer.append(complexCnt);
        Collections.sort(homeCntOfComplex);
        for (int c: homeCntOfComplex) answer.append("\n").append(c);
        System.out.println(answer);
    }
    static int N;
    private static void inputAndMakeGraph() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i=0; i<N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(c[j]));
            }
        }
    }
    private static int connectOneComplex(int i, int j) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(i, j));
        visited[i][j] = true;
        int homeCnt = 1;
        while (!que.isEmpty()) {
            Node node = que.poll();
            // 4방면 중 연결되는 땅이 있는지 확인
            for (int k=0; k<4; k++) {
                int adjX = node.x + dirX[k];
                int adjY = node.y + dirY[k];
                if (adjX>=0 && adjX<N && adjY>=0 && adjY<N &&
                        !visited[adjX][adjY] && map[adjX][adjY] == 1) {
                    que.add(new Node(adjX, adjY));
                    visited[adjX][adjY] = true;
                    homeCnt++;
                }
            }
        }
        return homeCnt;
    }
}