package language.java.Baek;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_15650 {

    static boolean[] visited;
    static int[] arr;
    static int N,M; // 백트래킹을 구현할 때, 전역변수로 선언을해서 dfs 메서드에서 사용할 수 있게 끔합니다.
    static StringBuilder sb = new StringBuilder();

    static void backtracking(int start, int depth) {
        // Base case (탈출조건) 깊이가 M 일시 입니다.
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 백트래킹(재귀) 구현
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                //if (depth != 0 && arr[depth] < arr[depth-1]) continue;
                backtracking(i + 1, depth+1); // 전체 루프를 도는 게 아닌, 미리 초기값을 설정해 줍니다.
                //dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 탐색 횟수
        M = Integer.parseInt(st.nextToken()); // 깊이

        arr = new int[M];
        visited = new boolean[N];
        backtracking(0, 0); // 초기값을 받은 N, M이 아닌, 0으로 시작해서 오름차순으로 루프를 돌게끔 초기값 세팅을합니다.
        System.out.println(sb);

    }
}