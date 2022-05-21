public class Pro_12980 {
//    public static int count = 1;
    public static int recursion(int n, int count) {
        if (n <= 2) return count;
        if (n % 2 == 0) {
            return recursion(n / 2, count);
        }
        else {
            return recursion(n - 1, count + 1);
        }
    }
    
    public static int solution(int n) {
//        System.out.println(recursion(n, 1));
        
        return recursion(n, 1);
//        int[] dp = new int[1_000_000_001];
//        dp[1] = 1;
//        dp[2] = 1;
//
//        for (int i = 0; i < dp.length; i++) {
//            if (i % 2 == 0)
//                dp[i] = dp[i / 2];
//            else
//                dp[i] = dp[i - 1] + 1;
//        }
//
//        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(solution(65));
    }
}
