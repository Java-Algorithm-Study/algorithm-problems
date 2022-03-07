import java.io.*;

/**
 * [10820] 문자열 분석
 * https://www.acmicpc.net/problem/10820
 */

public class Boj10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        String str = "";

        while ((str = br.readLine()) != null) {
            sb = new StringBuilder();
            int[] ans = new int[4];
            char[] ch = str.toCharArray();
            for (char x : ch) {
                if (Character.isLowerCase(x)) {
                    ans[0] += 1;
                }

                else if (Character.isUpperCase(x)) {
                    ans [1] += 1;
                }

                else if (Character.isDigit(x)) {
                    ans[2] += 1;
                }

                else {
                    ans[3] += 1;
                }
            }

            for (int x : ans) {
                sb.append(x).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
