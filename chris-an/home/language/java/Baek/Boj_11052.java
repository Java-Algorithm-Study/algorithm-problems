package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11052 {

    /*
        돈을 최대한 많이 지불해서 카드 N개를 구매하려고 한다.

        예시1)
        P1 = 1 => 카드가 1개 들어있고, 가격은 1원
        P2 = 5 => 카드가 2개 들어있고, 가격은 5원
        P3 = 6 => 카드가 3개 들어있고, 가격은 6원
        P4 = 7 => 카드가 4개 들어있고, 가격은 7원
            * N = 2 : 최댓값 10원 카드는 P2를 2번

        예시2)
        P1 = 5 => 카드가 1개 들어있고, 가격은 5원
        P2 = 2 => 카드가 2개 들어있고, 가격은 2원
        P3 = 8 => 카드가 3개 들어있고, 가격은 8원
        P4 = 10 =>  카드는 4개 들어있고, 가격은 10원
            * N = 4 : 최대값 20원 카드는 P1을 4번

        예시3)
        P1 = 3 => 카드가 1개 들어있고, 가격은 3원
        P2 = 5 => 카드가 2개 들어있고, 가격은 5원
        P3 = 15 => 카드가 3개 들어있고, 가격은 15원
        P4 = 16 =>  카드는 4개 들어있고, 가격은 16원
            * N = 4 : 최댓값 18원 카드는 P1을 1번, P3을 1번
     */
    static int dp [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        int P [] = new int[N+1];

        // P1 부터 시작이니, 초깃값은 1로 설정
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < P.length; i++) { // P의 카드팩을 배열에 담아 놓는다. DP 테이블 세팅 할 때, 필요.
            P[i] = Integer.parseInt(st.nextToken());
        }
        // 루프를 돌 때, 작은 문제부터 해결 따라서, A1에서 가장 큰최대값, A2에서 가장큰최대값..............최종 An 에서 가장큰 최대값.
        for(int i = 1 ; i < dp.length;i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], P[j] + dp[i - j]); // A2 => A1 + A1
            }                                              //       A2
        }                                                  // A3 => A1 + A2
        //       A2 + A1
        System.out.println(dp[N]);                         //       A3 + A0

    }
}





