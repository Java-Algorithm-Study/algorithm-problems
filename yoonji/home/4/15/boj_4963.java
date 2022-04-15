import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 섬의 개수
public class boj_4963 {
    static int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};
    static boolean[][] visited;
    static int[][] map;
    static int w,h;
    private static class Node {
        private int x;
        private int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        // 0,0 아닐때까지 반복
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w==0 && h==0) break;
            // 1. 인접 그래프 생성
            map = new int[h][w];
            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 2. 각 위치를 탐색하면서 방문하지 않은 "땅"일 경우 인접 섬을 구한다.
            int islandsCnt = 0;
            visited = new boolean[h][w];
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (visited[i][j] || map[i][j] != 1) continue;
                    connectOneIsland(i, j);
                    islandsCnt++;
                }
            }
            answer.append(islandsCnt).append("\n");
        }
        System.out.println(answer);
    }

    private static void connectOneIsland(int i, int j) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(i, j));
        while (!que.isEmpty()) {
            Node node = que.poll();
            // 8방면 중 연결되는 땅이 있는지 확인
            for (int k=0; k<8; k++) {
                int adjX = node.x + dirX[k];
                int adjY = node.y + dirY[k];
                if (adjX>=0 && adjX<h && adjY>=0 && adjY<w &&
                        !visited[adjX][adjY] && map[adjX][adjY] == 1) {
                    visited[adjX][adjY] = true;
                    que.add(new Node(adjX, adjY));
                }
            }
        }
    }
}
