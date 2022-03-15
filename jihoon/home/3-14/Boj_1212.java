import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1212 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String a = Integer.toBinaryString(Character.getNumericValue(s.charAt(i)));

            if (a.length() == 2 && i != 0) a = "0" + a;
            else if (a.length() == 1 && i != 0) a = "00" + a;

            sb.append(a);
        }
        System.out.println(sb);
    }
}
