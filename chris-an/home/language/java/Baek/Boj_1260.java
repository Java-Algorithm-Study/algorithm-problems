package language.java.Baek;

import java.io.*;
import java.util.*;

public class Boj_1260 {

    static int[][] check; // 간선 연결상태
    static boolean[] checked; // 확인 여부
    static int N; // 정점개수
    static int M; // 간선개수
    static int start; // 시작정점

    public static void dfs(int i) {
        checked[i] = true;
        System.out.print(i + " ");

        for(int j = 1; j <= N; j++) {
            if(check[i][j] == 1 && checked[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        checked[start] = true;
        System.out.print(start + " ");

        while(!qu.isEmpty()) {
            int temp = qu.poll();

            for(int j = 1; j <= N; j++) {
                if(check[temp][j] == 1 && checked[j] == false) {
                    qu.offer(j);
                    checked[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        check = new int[1001][1001]; // +1
        checked = new boolean[1001];  // +1

        // 간선 연결상태 저장
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            check[x][y] = check[y][x] = 1; // 인접행렬 초기화
        }

        dfs(start);

        checked = new boolean[1001]; // 상태 초기화

        System.out.println();

        bfs();
    }
}