package diff1;

import java.util.Scanner;

public class Sw_거꾸로출력해보아요 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = N; i >= 0; i--) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}
