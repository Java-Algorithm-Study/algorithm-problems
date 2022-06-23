package diff1;

import java.util.Scanner;

public class Sw_자릿수더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < st.length(); i++) {
            sum += st.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}
