package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9095 {

    /*
         규칙찾기
         1. 일단 4까지 더한 예시를 보고 추가적으로 7은 출력예시에 출력값이 있으니, 6까지 구하기.
         2. 규칙성 찾기
            2-1   5 => 13번
                   6 => 24번
                   7 => 44번
            2.2 일단 N이 3일 때를 구했을 때, 3개라고 생각을 함. 3->13->24->44 로 분석
            2.3 계속 규칙성을 못찾아서 점화식을 못 만들다가.
            2.4 N이 3일 때가 뭔가 잘못된 게 아닐까? 의심하고 문제를 다시 읽어보니. '합을 나타낼 때는 수를 1개 이상 사용해야 한다.' 에 눈에 들어옴
            2.5 다시 새로운 규칙성 4->13->24->44 를 규칙성 찾고
            2.6 An= An-1 + An-2 + An-3 의 규칙성이 눈에보여 10까지를 계산해보고 출력값이 맞는 걸 확인하고 로직을 짬.

            기본 점화식 : An= An-1 + An-2 + An-3
     */

    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ordCnt = Integer.parseInt(br.readLine());

        while (ordCnt-- > 0) {
            int N = Integer.parseInt(br.readLine());
            dp = new int[N+1];
            for (int i = 0; i < dp.length; i++) {
                if (i < 3) dp[i] = i;
                else if (i == 3) dp[i] = 4;
                else {
                    dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
                }
            }
            System.out.println(dp[N]);
        }

    }
}



