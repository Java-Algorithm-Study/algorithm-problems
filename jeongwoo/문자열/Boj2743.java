import java.io.*;

/**
 * [2743] 단어 길이
 * https://www.acmicpc.net/problem/2743
 */

public class Boj2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        sb.append(str.length());
        System.out.println(sb.toString());
    }
}
