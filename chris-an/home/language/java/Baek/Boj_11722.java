package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11722 {
    static int [] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());

        DP = new int[A+1];
        Arrays.fill(DP, 1); // 길이는 기본 세팅 1로 초기화합니다.
        int [] target = new int[A+1];

        // 배열에 먼저 받은 입력값을 담습니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            target[i] = Integer.parseInt(st.nextToken());
            //System.out.println(target[i]);
        }


        for (int i = 1; i < A; i++) {
            for (int j = 0; j < i; j++) {
                if (target[j] > target[i] && DP[j] >= DP[i]) { // 1부터 시작해서 값 비교를하여, 인덱스 낮은 값이 크며, 길이를 비교해주면서 DP 세팅을 합니다.
                    DP[i] = DP[j] + 1;
                }
            }
        }

        int max = 0;
        for (int n : DP) {
            if (n > max) max = n;
        }
        System.out.println(max);

    }
}