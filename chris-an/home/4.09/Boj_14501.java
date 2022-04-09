import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14501 {

    static int N;
    static int[] T;
    static int[] P;
    static int retirementDday;
    static int max;

    static void dfs(int day, int sumMoney) {
        if (day == N) {
            max = Math.max(max, sumMoney);
            return;
        }

        dfs(day + 1, sumMoney); // 퇴사 직전 일자 세팅

        if (retirementDday > day + T[day]) { // 위 루프를 돈 상태에서, 퇴사 직전일부터 1일까지 상담일자 +, 상담금액 +
            dfs(day + T[day], sumMoney + P[day]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        retirementDday = N + 1;
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(max);
    }
}
