import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쉬운 계단 수
// N은 자릿수를 의미한다.
// N 자릿수의 자릿값으로 0부터 9까지의 값이 올 수 있다.
// N=4일 때 길이(자릿수)가 4이고 계단 수가 되는 경우의 수를 구해야 한다.
// 2차원 배열로 표현 : D[N+1][10] : 1~N만큼의 자릿수, 0~9까지의 자릿값
// 자릿값이 0일 때는  그 뒷 자릿수 값이 1인 경우 뿐
// 자릿값이 9일 때는 그 뒷 자릿수 값이 8인 경우 뿐
// 그외는 +1이거나 -1인 경우를 합쳐야 모든 경우의 수를 계산할 수 있다.
public class boj_10844 {
    static long MOD = 1_000_000_000;   // modulo
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];
        // 자릿수 1의 자리에는 1가지 경우 밖에 없다. (2번째 자리로부터 정해지는 경우 1가지뿐)
        for (int i=0; i<10; i++)
            dp[1][i] = 1L;  // 0부터 9까지 모두 한가지 경우

        // 자릿수 N이 최대 100이므로 long 타입을 벗어나지 않도록 나머지값으로 받아야하고, int 타입은 벗어나니 long으로 선언한다.
        long answer = 0;
        // ※ N의 모든 자릿값을 돌며 경우의 수를 answer에 추가
        for (int i=1; i<=9; i++) {
            answer += recur(N, i);      // 자릿수, 자릿값
        }
        System.out.println(answer % MOD);
    }
    // top down
    private static long recur(int digit, int value) {
        // 자릿수가 1이 되면 return
        if (digit == 1) return dp[digit][value];
        // 아직 값이 채워지지 않은 경우
        if (dp[digit][value] == 0) {
            if (value == 0) dp[digit][value] = recur(digit-1, 1);  // 값이 0이면 1로 지정
            else if (value == 9) dp[digit][value] = recur(digit-1, 8);  // 값이 9면 8로 지정
            else {
                dp[digit][value] = (recur(digit-1, value+1) + recur(digit-1, value-1));
            }
        }
        return dp[digit][value] % MOD;  // ※ 각 if문에서 하기보다 마지막에 리턴할 때 %MOD를 해서 long범위를 벗어나지 않도록 해야한다.
    }
}