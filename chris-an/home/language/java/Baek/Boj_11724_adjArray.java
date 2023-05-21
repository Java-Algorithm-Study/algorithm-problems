package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11724_adjArray {

    static int N; // 정점
    static int M; // 간선
    static int[][] adj;  //인접행렬
    static boolean[] visited; // 방문체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N+1][N+1]; // 정점 기준으로 인접행렬을 만듭니다.


        for (int i = 0; i < M; i++) { // 간선 기준으로 인접행렬을 세팅
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = adj[y][x] = 1; // 1로 체크
        }

        /*  예제입력1
       idx 0 1 2 3 4 5 6
        1  * 0 1 0 0 1 0
        2  * 1 0 0 0 1 0
        3  * 0 0 0 1 0 0
        4  * 0 0 1 0 0 1
        5  * 1 1 0 0 0 0
        6  * 0 0 0 1 0 0
         */

        visited = new boolean[N + 1]; // 정점갯수가 인덱스끝에 맞춰 초기화

        int count = 0; // 연결 요소의 개수

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int start) {
        visited[start] = true; // 방문을 했다는 표시

        for (int i = 1; i < N + 1; i++) { // 1부터 N까지 roof
            if (adj[start][i] == 1 && !visited[i]) { // 인접행렬
                dfs(i);
            }
        }
    }
}
