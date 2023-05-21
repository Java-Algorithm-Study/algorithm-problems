package language.java.Baek;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_15649 {

    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void backtracking(int N, int M, int depth) {

        // 베이스케이스 (탈출조건) 구현
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 백트래킹 재귀 함수 구현
        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 방문 체크할 때, 중복확인을해서 숫자가 중복으로 나오지 않게끔 합니다.
                visited[i] = true;
                arr[depth] = i + 1;
                backtracking(N, M, depth + 1); // 루프를 돌다가 M의 갯수가 4, 깊이가 4일 때 나오게되면서
                visited[i] = false;   // visited false 처리를 해줍니다.
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 탐색 횟수
        int M = Integer.parseInt(st.nextToken()); // 깊이

        arr = new int[M];
        visited = new boolean[N];
        // 초깃값 설정을 어떻게 줄지 결정
        backtracking(N, M, 0); // N이 1부터 시작이고 +1 depth를 해주기 위해서 depth를 0으로 초기세팅합니다.
        System.out.println(sb);

    }
}