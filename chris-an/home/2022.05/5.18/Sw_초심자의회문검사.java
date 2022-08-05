import java.util.Scanner;

public class Sw_초심자의회문검사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            String line = sc.next();

            int len = line.length();
            int end = len / 2;

            boolean flag = true;
            for (int i = 0; i < end; i++) {
                char charStart = line.charAt(i);
                char charEnd = line.charAt(line.length()-1-i);

                if (charStart != charEnd) {
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println("#" + tc + " " + 1);
            else System.out.println("#" + tc + " " + 0);
        }
    }
}
