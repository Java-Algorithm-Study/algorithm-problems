import java.util.Scanner;

/**
 * [9093] 단어 뒤집기
 * https://www.acmicpc.net/problem/9093
 */

public class Boj9093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] arr = str.split(" ");

            for (int j = 0; j < arr.length; j++) {
                String temp = new StringBuilder(arr[j]).reverse().toString();
                System.out.print(temp + " ");
            }
            System.out.println();
        }

    }
}
