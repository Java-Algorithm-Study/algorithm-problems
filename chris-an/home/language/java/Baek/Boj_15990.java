package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//int 표현 범위의 한계가 약 20억이므로, 2개의 수를 더했다면 % 1000000009  를 연산해주자.

public class Boj_15990 {

    // 2차배열을 가지고 마지막에 더한 수를 표시해줍니다.
    static long [][] dp = new long[100001][4];
    static int maxN = 100001; // 받는 정수 N은 최대값이 100,000보다 적거나 같습니다.
    static final int MOD = 1000000009; // 미리 문제에 제시된 나눠야할 값을 상수화 시켜놓습니다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ordCnt = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수를 받습니다.

        // 미리 N이 1,2,3 일 때 초기화를 시켜 놓습니다.
        // dp 를 초기화할 때, 0으로 값이 저장 되어있어. 0을 또 다시 초기화 할 필요는 업습니다.
        dp[1][1]=1;
        //dp[1][2]=0;
        //dp[1][3]=0;

        //dp[2][1]=0;
        dp[2][2]=1;
        //dp[2][3]=0;

        dp[3][1]=1;
        dp[3][2]=1;
        dp[3][3]=1;

        // dp 세팅을 해줍니다.
        // N이 6일 때를 기준으로 설명을하자면,
        for (int i = 4; i < maxN; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD; // N이 5일 때, +1를 하면, 6이 된다
            // -> 고로, +1+1 겹치면 안되니, N이 5일 때, 2나 3으로 끝난 DP 저장 값을 가져온다.
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD; // N이 4일 때, +2를 하면, 6이 된다.
            // -> 고로, +2+2 겹치면 안되니, N이 4일 때, 1이나, 3으로 끝난 DP 저장 값을 가져온다.
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD; // N이 3일 때, +3을 하면, 6이 된다.
            // -> 고로, +3+3 겹치면 안되니, N이 3일 때, 1이나, 2로 끝난 DP 저장 값을 가져온다.
        }

        while (ordCnt-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println((dp[N][1] + dp[N][2] + dp[N][3]) % MOD);
        }

    }
}