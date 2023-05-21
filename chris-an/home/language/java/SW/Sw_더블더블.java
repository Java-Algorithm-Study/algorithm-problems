package language.java.SW;


import java.util.Scanner;

public class Sw_더블더블 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(' ');
        for (int i = 0; i < N; i++) {
            sb.append(((int) Math.pow(2, i + 1))).append(' ');
        }
        System.out.println(sb);
    }
}
