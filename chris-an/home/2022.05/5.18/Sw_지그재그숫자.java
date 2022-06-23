package diff2;

import java.util.Scanner;

public class Sw_지그재그숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int sum = 0;
            int N = sc.nextInt();
            for (int i = 1; i <= N; i++) {
                // 짝수는 -
                if (i % 2 == 0)
                    sum -= i;
                // 홀수는 +
                else
                    sum += i;
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
}
