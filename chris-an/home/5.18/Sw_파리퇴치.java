package diff2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_파리퇴치 {
    static int N, M;
    static int[][] map;

    static int matrix3by3(int r, int c, int max) {
        int sum = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sum += map[r + i][c + j];
            }
        }
        max = Math.max(max, sum);

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        // 테스트케이스 갯수
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());


            // inputData settings
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }



            // 파리채 스윙 기준 루프
            int max = Integer.MIN_VALUE;
            for (int i = 0 ; i <= N - M; i++) {
                for (int j = 0 ; j <= N-M; j++) {
                    max = matrix3by3(i , j, max);
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}
