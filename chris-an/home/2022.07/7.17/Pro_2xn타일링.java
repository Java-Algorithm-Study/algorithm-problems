public class Pro_2xn타일링 {
    int[] dp;
    final int mod = 1_000_000_007;
    public int solution(int n) {
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % mod + dp[i - 2] % mod;
        }
        return dp[n] % mod;
    }
}
