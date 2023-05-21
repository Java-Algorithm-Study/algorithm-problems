package language.java.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_어디에단어가들어갈수있을까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());


        for (int tc = 1; tc <= T; tc++) {
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int wordLength = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {

                        // column 증가 (가로)
                        int move = 1;
                        while (true) {
                            if (j + move >= N) break;
                            if (map[i][j + move] == 1) move++;
                            else break;
                        }
                        if (move == wordLength) {
                            if (j == 0) cnt++;
                            else if (move == wordLength && map[i][j - 1] != 1) cnt++;
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[j][i] == 1) {
                        // row 증가 (세로)
                        int move = 1;
                        while (true) {
                            if (j + move >= N) break;
                            if (map[j + move][i] == 1) move++;
                            else break;
                        }
                        if ((move == wordLength)) {
                            if (j == 0) cnt++;
                            else if (move == wordLength && map[j-1][i] != 1) cnt++;
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}