package language.java.Programmers;/*
두 가지 방법 (*n을 짝수로 for문 세팅)

규칙1 : f(n)= f(n-2)*4 - f(n-4)
    규칙 1번은 하향식 규칙을 사용했으므로, 모듈러 분배규칙 이용해야한다.
    또한 n의 -4를 해야하니, n이 6번째까지 모형을 구했을 때, 찾을 수 있는 점화식 같다.


규칙2 : f(n) = f(n-1) x 3 + f(n-2) x 2 + … + f(2) x 2 + 2
    규칙 2번은 다 그려보고, 분석을 하면 찾을 수 있을 거 같지만 쉽지 않고 어렵다.

*/

public class Pro_3xn타일링 {
    long[] tile = new long[5001];
    final int MOD = 1_000_000_007;
    /**
     * 규칙1 점화식으로 푼 로직
     */
    public long solution1(int n) {
        int MOD = 1_000_000_007;

        tile[0] = 1;
        tile[2] = 3;

        for (int i = 4; i <= n; i += 2){
            tile[i] = (tile[i-2] * 4 % MOD - tile[i-4] % MOD + MOD) % MOD;

        };

        return tile[n];
    }

    /**
     * 규칙2 점화식으로 푼 로직
     */
    public long solution2(int n) {
        tile[0] = 1;
        tile[2] = 3;

        for (int i = 4; i <= n; i += 2){
            tile[i] = tile[i-2] * 3;

            for (int j = i - 4; j >= 0; j -= 2){
                tile[i] += tile[j] * 2;
            }
            
            tile[i] = tile[i] % MOD;
        };

        return tile[n];
    }
}