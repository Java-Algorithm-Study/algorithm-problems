package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14391 {

    /*
        종이조각(14391)
        https://www.acmicpc.net/problem/14391
     */

    static int N, M;
    static boolean[] visited;
    static int[] map;
    static int max;


    private static void dfs(int idx) {
        if (idx == N * M) {
            check();
            return;
        }

        // 해당 좌표 선택 -> 가로
        visited[idx] = true;
        dfs(idx + 1);
        visited[idx] = false;

        // 해당 좌표 미선택 -> 세로
        dfs(idx + 1);
    }

    private static void check() {
        int sum = 0;
        int temp;

        for (int i = 0; i < N; i++) {
            temp = 0;
            for (int j = 0; j < M; j++) {
                if (visited[i * M + j]) {
                    temp *= 10;
                    temp += map[i * M + j];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }


        for (int j = 0; j < M; j++) {
            temp = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i * M + j]) {
                    temp *= 10;
                    temp += map[i * M + j];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }

        max = Math.max(max, sum);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N * M];
        map = new int[N * M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                // 2차원 배열을 1차원배열로 만들어서 인덱스를 조작합니다.
                map[i * M + j] = input.charAt(j) - '0';
            }
        }

        dfs(0);
        System.out.println(max);
    }
}