
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1373 {
    /*
        2진수가 주어졌을 때, 8진수로 변환하는 프로그램은?
       2진법 -> 8진법
        001 -> 1
        010 -> 2
        011 -> 3
        100 -> 4
        101 -> 5
        110 -> 6
        111 -> 7
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        if (N.length() % 3 == 1) N = "00" + N;
        else if (N.length() % 3 == 2) N = "0" + N;

        for (int i = 0; i < N.length(); i+=3) {
            sb.append((N.charAt(i) - '0') * 4 +
                    (N.charAt(i+1) - '0') * 2 +
                    (N.charAt(i+2) - '0'));
        }
        System.out.println(sb);
    }
}
