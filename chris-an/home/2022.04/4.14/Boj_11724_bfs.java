import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11724_bfs {

    static int N, M;
    static boolean[][] adj;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 양방향으로 미리 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = adj[y][x] = true;
        }


        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) { // 방문 됐다면 pass 안됐다면, in
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void bfs(int node) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(node); // 1. 일단 큐에 먼저 집어 넣기
        visited[node] = true; // 2. 현재 노드 방문처리해주기

        while (!qu.isEmpty()) { // 큐가 빌 때까지 인접노드 루프돌기
            int cur = qu.poll(); // 1. 일단 큐에서 하나 뺴기

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i] && adj[cur][i]) { // 미방문 && cur의 idx에 있는 2차원 값 싸악 확인 하여, 인접노드가 있을시.
                    visited[i] = true; // 2. 위(if) 조건에 맞을 시, 인접노드에 방문처리
                    qu.offer(i); // 3. 방문처리 된 뒤, 다시 큐에 인접노드 삽입
                }
            }
        }
    }
}

