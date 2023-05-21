package language.java.Baek;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_17404 {
    static int[][] DP;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DP = new int[1001][3];
        int [][] arr = new int[1001][3];

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        // 우선 원래 배열 초기화
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        // 0번째 집을 어떤색으로 칠하느냐에 따라 각각 최소값을 구할 수 있으니 3번 반복
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == j) DP[0][j] = arr[0][i]; // 0 번째 집을 현재 i 값과 같을 때, 배열값 세팅합니다.
                else DP[0][j] = 1000 * 1000 + 1; // 최대 1,000,001 을 넘지 않습니다. // 나머지는 최소 비용이 나올 수 없는 값으로 초기화 한다.
            }
            // 반복문을 통해 모든 집을 칠하는 경우를 구해나간다.
            for(int j = 1; j < N; j++){
                DP[j][0] = Math.min(DP[j-1][1], DP[j-1][2]) + arr[j][0];
                DP[j][1] = Math.min(DP[j-1][0], DP[j-1][2]) + arr[j][1];
                DP[j][2] = Math.min(DP[j-1][0], DP[j-1][1]) + arr[j][2];
            }

            // n-1번째까지 구해진 값 중 최소 비용의 값을 구한다.
            for(int j = 0; j < 3; j++) {
                if(i == j) continue;
                min = Math.min(min, DP[N-1][j]);
            }
        }
        System.out.println(min);
    }
}