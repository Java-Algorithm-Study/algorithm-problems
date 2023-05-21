package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13398_2 {
    static int [][] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N+1];
        DP = new int[N+1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기화, 0번째는 그 수 입니다.
        DP[0][0] = arr[0];
        DP[0][1] = arr[0];

        int max = arr[0];
        for (int i = 1; i < N; i++) {
            // 기존 연속합 최대를 구하는 점화식입니다.
            DP[i][0] = Math.max(arr[i],DP[i-1][0] + arr[i]);

            // 수 i를 제거한 값과,
            // 이전에 제거된 수가 있는 경우, 이전 최대 연속합에 i번째 값을 더해줍니다.
            DP[i][1] = Math.max(DP[i-1][0], DP[i-1][1] + arr[i]);
            // 그리고, 0,1 에 있는 값을 비교 한뒤, max 값을 최신화 시켜줍니다.
            max = Math.max(max,Math.max(DP[i][0], DP[i][1]));

        }
        System.out.println(max);
    }
}
