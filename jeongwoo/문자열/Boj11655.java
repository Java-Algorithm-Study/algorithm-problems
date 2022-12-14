import java.io.*;

/**
 * [11655] ROT13
 * https://www.acmicpc.net/problem/11655
 */

public class Boj11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] ch  = br.readLine().toCharArray();

        for (char x : ch) {
            if (Character.isUpperCase(x)) {
                x += 13;
                if (x > 'Z') {
                    x -= 26;
                }
                sb.append(x);
            }
            else if (Character.isLowerCase(x)) {
                x += 13;
                if (x > 'z') {
                    x -= 26;
                }
                sb.append(x);
            }
            else {
                sb.append(x);
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
