/**
 * [12980] 점프와 순간 이동
 * https://programmers.co.kr/learn/courses/30/lessons/12980
 *
 * -아이디어
 * 1. if (n % 2 == 0) -> dp[n] = dp[n/2]
 * 2. else dp[n] = dp[n-1] + 1
 * 3. 이렇게 하면 효율성 통과를 못 한다.
 * 4. 그래서 생각한 게 재귀. 
 * 5. n이 짝수라면 n/2까지 가는 에너지와 같다. 즉, 배터리 소모가 안 된다.
 * 6. n이 홀수라면 배터리 소모는 (n-1)/2 + 1과 같아서 count++.
 * 
 */

public class Pro12980 {
    public static void main(String[] args) {
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        return recursion(n, 1);
    }

    public static int recursion(int n, int count) {
        if (n <= 2) {
            return count;
        }
        
        if (n % 2 == 0) {
            return recursion(n / 2, count);
        } 
        else {
            return recursion(n - 1, count + 1);
        }
    }
}
