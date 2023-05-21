package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Boj_11055 {
    static int [] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());

        DP = new int[A+1];
        int [] arr = new int[A+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열로 세팅을 해줍니다.
        for (int i = 1; i <= A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기화
        DP[1] = arr[1]; // 첫번 째 값은 합이 자기자신입니다.

        for (int i = 2; i <= A; i++) {
            DP[i] = arr[i]; // 먼저 자기자신으로 초기화 시켜줍니다.
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    DP[i] = Math.max(DP[j] + arr[i], DP[i]); // 자기자신과, DP를 0부터 시작(j루프)해서 저장된 값과 더 해주면서 최대값을 찾습니다.
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