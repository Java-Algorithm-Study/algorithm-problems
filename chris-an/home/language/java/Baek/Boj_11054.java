package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11054 {
    static int [] DP_leftToRight;
    static int [] DP_rightToLeft;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target[] = new int[N + 1];

        DP_rightToLeft = new int[N + 1];
        DP_leftToRight = new int[N + 1];

        // 왼->오 (인덱스1를 1길이로 초기화)
        // 오->왼 (인덱스N를 1길이로 초기화)
        DP_leftToRight[1] = 1;
        DP_rightToLeft[N] = 1;

        // 배열로 일단 세팅
        for (int i = 1; i < target.length; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        // 왼 -> 오, 각 DP[N]에 가장 긴 늘어나는 부분 수열 값 세팅
        for (int i = 2; i <= N; i++) {
            DP_leftToRight[i] = 1; // 1로 초기화하는 작업 why? 아래 if 구현부 쪽에서 떄문에 초기화
            for (int j = 1; j < i; j++) {
                if (target[i] > target[j]) {
                    DP_leftToRight[i] = Math.max(DP_leftToRight[j] + 1, DP_leftToRight[i]); // DP에 저장된 길이 값과 자기 자신을 더한 길이를 순차적으로 비교하면서 최대값을 찾음.
                }
            }
        }

        // 오 -> 왼, 위와 동일함.
        for (int i = N-1; i > 0; i--) {
            DP_rightToLeft[i] = 1;
            for (int j = N; j > i; j--) {
                if (target[i] > target[j]) {
                    DP_rightToLeft[i] = Math.max(DP_rightToLeft[j] + 1, DP_rightToLeft[i]);
                }
            }
        }

        // 두 배열을 더해줍니다.
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int temp = DP_leftToRight[i] + DP_rightToLeft[i];
            //System.out.println(temp);
            if (temp > max) max = temp;
        }

        // 겹치는 갯수 한 개를 빼줍니다.
        System.out.println(max-1);
    }
}