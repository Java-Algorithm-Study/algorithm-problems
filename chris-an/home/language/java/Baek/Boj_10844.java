package language.java.Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boj_10844 {

    final static long MOD = 1000000000;
    /*
            long[N][[V] -> N:자릿수(자릿수는 0부터 시작하기 때문에 N+1)
                           V:자릿값
     */
    static long [][] DP;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        DP = new long[N + 1][10];
        // 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음
        for(int i = 1; i < 10; i++) { // 1~9(9번루프)
            DP[1][i] = 1; // 자릿수를 1로 일단 초기 세팅
        }

        // 두 번째 자릿수부터 N까지 탐색
        for(int i = 2; i <= N; i++) {

            // i번째 자릿수의 자릿값들을 탐색 (0~9)
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    DP[i][0] = DP[i - 1][1] % MOD; // 끝 자리가 0은 무조건 1과 붙을 수밖에 없다..
                }
                else if (j == 9) {
                    DP[i][9] = DP[i - 1][8] % MOD; // // 끝자리 9일 때도 마찬가지로 1과 붙을 수 밖에 없다.
                }
                // 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨
                else {
                    DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j + 1]) % MOD;
                    // i가 2일 때, iX
                    // i가 3일 때, iXX
                    // i가 4일 때, iXXX
                }
            }
        }
        long sum = 0; //각 자릿수에있는 자릿 값을 더해주기 위한 변수입니다.
        for(int i = 0; i < 10; i++) {
            sum += DP[N][i];
        }
        System.out.println(sum % MOD);
    }
}