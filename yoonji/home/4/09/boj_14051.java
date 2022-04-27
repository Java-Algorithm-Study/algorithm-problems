import java.io.*;
import java.util.*;
// 퇴사
// dp[i] = max(i일자를 제외한 상담소득의 최댓값, i일자 소득 + i일자의 상담소요시간 이후 일자의 소득 최댓값)
public class boj_14051 {
    static int[][] schedule;
    static int N;
    static int[] dp;   // i일자 까지의 상담 수익 중 최댓값
    public static void main(String[] args) throws IOException {
        input();
        dp= new int[N+2];
        calculateConsulting();
        System.out.println(dp[1]);
    }
    // 현재 상담날짜 기준 수익 최댓값(dp[i])은 아래 중 Max값이다.
    // 1. 금일 상담 비용 + 그뒤로 가능한 상담일자의 수익 최댓값(dp)
    // 2. 금일을 제외한(+1) 상담일자의 수익 최대값(dp)
    private static void calculateConsulting() {
        for (int i=N; i>0; i--) {
            int nextConsultDate = i + schedule[0][i];
            if (nextConsultDate > N+1) dp[i] = dp[i+1]; // 초과되면 해당 날짜를 dp에 포함X
            else dp[i] = Math.max(dp[i+1], schedule[1][i]+dp[nextConsultDate]);
        }
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        schedule = new int[2][N+1]; // 1일~N일
        StringTokenizer st;

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            schedule[0][i] = Integer.parseInt(st.nextToken());  // 소요 날짜
            schedule[1][i] = Integer.parseInt(st.nextToken());  // 수익
        }
    }
}
        /*잘못된 내 풀이 (앞에서부터 계산)
        // i=1~N까지 반복문을 돌며 calculateConsulting(i)를 호출하고, 다시 반복문읃 돌며 max값을 구한다.
        private static void calculateConsulting(int date) {
            if (date>=N+1) return;  // 상담 일자가 N+1과 같거나 더 크면 끝
            int consultTerm = schedule[0][date];
            for (int i=date+consultTerm; i<= N; i++) {
                if (i+schedule[0][i] > N+1) continue;   // 상담완료 일자가 N+1보다 같거나작은가?
                int income = dp[date]+ schedule[1][i];
                dp[i] = Math.max(dp[i], income);    // 더 큰 누적 수익 값으로 변경
                calculateConsulting(i+schedule[0][i]);
        }*/