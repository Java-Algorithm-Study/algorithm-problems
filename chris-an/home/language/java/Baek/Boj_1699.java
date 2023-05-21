package language.java.Baek;

import java.util.Scanner;
public class Boj_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] DP = new int[N+1];
        DP[1] = 1;
        for(int i = 2; i < N+1; i++) {
            DP[i] = i;
            for(int j = 1; j * j <= i; j++)
                DP[i] = Math.min(DP[i], DP[i - (j*j)] + 1);
        }

        System.out.println(DP[N]);
    }
}