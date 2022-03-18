import java.util.Scanner;

// 1로 만들기
// 1<=N<=1_000_000
// N을 3으로 나누거나 / 2로 나누거나 / -1을 해서 -> 1로 만든다.
// 위 순서대로 계산을 시도해보는 방식은 X (1차 실패)
// 각각의 경우의 수를 비교해봐야할듯함 => DP
// dp[n] 에 들어갈 값은 최소의 계산값, index는 현재 N의 값
// dp 배열의 크기는 N+1만큼
public class boj_1463 {
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;  // 작은 크기 초기화. 지정해두지 않으면 OutOfBounds
        System.out.println(topdown(N));
    }
    // 문제풀이 시 아래 방식으로 하면 안되지만, 재귀의 흐름을 보기 위해 작성함.
    // 재귀로 dp[10]부터 -1, /3, /2를 순서대로 체크할 경우
    // dp[9] + 1                                                     / dp[5]+1
    // dp[8]+1                                 / dp[3] + 1           / dp[4] + 1
    // dp[7]+1                / dp[4]+1        / dp[2] + 1 , dp[1]+1 / dp[3] + 1, dp[2] + 1
    // dp[6]+1                  / dp[3]+1,dp[2]+1/    2    /    2    /    2    /   2
    // dp[5]+1,dp[3]+1,dp[2]+1  / 2     /   2   /
    // dp[4]+1,  2 ,   2
    // dp[3]+1,dp[2]+1
    // 2

    /**
     * 큰 수 -> 작은 수 + 재귀
     * @param n
     * -1을 먼저 계산하면 안된다. (실패2: 시간 초과...)
     * +1은 마지막에 해주자. (계산의 경우의 수 추가)
     */
    private static int topdown(int n) {
        if (dp[n] == null) {   // null이 아니면 이미 값이 있는 것이므로 아래 return으로 이동.dp[0]과 dp[1]을 만나면 아래 재귀함수를 호출하는 로직으로 가지않고 return함.

            // 6으로 나눠지는 경우 : /2와 /3을 비교 후, -1과 비교
            if (n % 6 == 0) {
                dp[n] = Math.min(topdown(n - 1), Math.min(topdown(n / 3), topdown(n / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (n % 3 == 0) {
                dp[n] = Math.min(topdown(n / 3), topdown(n - 1)) + 1;
            }
            // /2로만 나눠지는 경우
            else if (n % 2 == 0) {
                dp[n] = Math.min(topdown(n / 2), topdown(n - 1)) + 1;
            }
            // 그래도 안되는 경우 -1
            else {
                dp[n] = topdown(n - 1) + 1;
            }
        }
        return dp[n];
    }

    /**
     * 작은 수 => 큰수로 탐색 + for문
     * @param n
     */
    private static int bottomup(int n) {
        dp[0] = 0;
        if (n<=3) return 1;
        for (int i=1; i<=n; i++) {dp[i] =  + 1;
            if (i%6 == 0) {
                dp[i] = Math.min(dp[i - 1]+ 1, Math.min(dp[i / 2]+ 1, dp[i / 3]+ 1));
            }
            else if (i%2 == 0 && dp[i] > dp[i/2]+ 1) {
                dp[i] = dp[i/2] + 1;
            }
            else if (i%3 == 0 && dp[i] > dp[i/3] + 1) {  // dp[i]보다 dp[i/3]이 더 작은 경우에는 변경!
                dp[i] = dp[i/3] + 1;
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }
        return dp[n];
    }
}
