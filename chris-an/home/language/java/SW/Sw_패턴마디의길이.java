package language.java.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    2007. 패턴 마디의 길이 D2
 */
public class Sw_패턴마디의길이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            // 최대 마디 패턴 길이 10
            for (int j = 0; j < 10; j++) {
                sb.append(line.charAt(j));
                int len = sb.length();
                String targetB = line.substring(len, len*2);
                if (sb.toString().equals(targetB)) {
                    break;
                }
            }
            System.out.println("#" + i + " " + sb.length());
        }
    }
}
