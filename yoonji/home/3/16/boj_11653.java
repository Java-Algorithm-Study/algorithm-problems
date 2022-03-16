import java.util.Scanner;
// 소인수 분해
public class boj_11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int input = sc.nextInt();
        for (int i=2; i<=input; i++) {
            if (input == 1) break;
            if (input % i == 0) {
                sb.append(i).append("\n");
                input = input / i;
                i--;
            }
        }
        /*
        while (input != 1) {
            for (int i=2; i<=input; i++) {
                if (input % i == 0) {
                    sb.append(i).append("\n");
                    input = input / i;
                    break;  // 다시 2부터
                }
            }
        }
         */
        System.out.println(sb);
    }
}
