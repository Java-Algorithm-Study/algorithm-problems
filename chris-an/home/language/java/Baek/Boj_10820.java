package language.java.Baek;

import java.io.*;

public class Boj_10820 {
    public static void main(String[] args) throws IOException {

        /*
            아스키코드?
            - 48~57(0부터 9까지)
            - 65~90(A부터 Z까지)
            - 97~122(a부터 z까지)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while ((str = br.readLine()) != null) { // 여러줄을 받을 때 사용.
            int[] arr = new int[4];
            // 소문자, 대문자, 숫자, 공백 순서.
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') arr[0]++;
                else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') arr[1]++;
                else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') arr[2]++;
                else if (str.charAt(i) == ' ') arr[3]++;
            }
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.print("\n");
        }

    }
}
