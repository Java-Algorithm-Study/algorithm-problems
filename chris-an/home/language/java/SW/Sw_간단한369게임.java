package language.java.SW;

import java.util.Scanner;

public class Sw_간단한369게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String tempStr = String.valueOf(i);
            String str = "";
            String str1 = "";
            boolean flag = false;
            for (int j = 0; j < tempStr.length() ; j++) {
                int tempInt = tempStr.charAt(j) - '0';
                if (tempInt != 0 && tempInt % 3 == 0) {
                    str1 += "-";
                    flag = true;
                }
                if (!flag) str += tempStr.charAt(j);
            }
            if (flag) sb.append(str1).append(' ');
            else sb.append(str).append(' ');

        }
        System.out.println(sb);
    }
}
