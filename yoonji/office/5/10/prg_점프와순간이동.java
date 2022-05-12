// dp[i] = i번째 까지의 점프 최소 거리
// 5000 -> 2500 -> 1250 -> 625 -> 624 (answer++) -> 312 -> ....-> 1 -> 0 (answer++)
public class prg_점프와순간이동 {
    public int solution(int n) {
        if (n<=2) return 1;
        recur(n);
        return answer;
    }
    int answer = 0;
    public void recur(int n) {
        if (n==1) {
            answer++;   // 1->0 jump
            return;
        }
        if (n%2 == 0) {
            recur(n/2);
        } else {
            answer++;
            recur((n-1)/2);
        }
    }
}