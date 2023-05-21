package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2156 {
    static int [] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N+1];
        DP = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 초기화
        DP[0] = arr[0];
        DP[1] = arr[0] + arr[1];
        if (N > 2) DP[2] = Math.max(Math.max(arr[0]+arr[1], arr[0]+arr[2]), arr[1]+arr[2]);

        // 루프 DP
        for (int i = 3; i < N; i++) {
            DP[i] = Math.max(DP[i-1], Math.max(DP[i-2]+arr[i], DP[i-3] + arr[i] + arr[i-1]));
        }

        System.out.println(DP[N-1]);
    }
}