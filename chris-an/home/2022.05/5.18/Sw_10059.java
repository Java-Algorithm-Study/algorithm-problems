import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    유효기간 diff - 3
 */
public class Sw_10059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String line = br.readLine();
            boolean aYYcheck = false;
            boolean bYYcheck = false;
            boolean aMMcheck = false;
            boolean bMMcheck = false;
            int a = Integer.parseInt(line.substring(0,2));
            int b = Integer.parseInt(line.substring(2));

            // MM
            if (1 <= a && a <= 12) aMMcheck = true;
            // YY
            if (0 <= a && a <= 99) aYYcheck = true;
            // MM
            if (1 <= b && b <= 12) bMMcheck = true;
            // YY
            if (0 <= b && b <= 99) bYYcheck = true;

            if (aMMcheck && aYYcheck && bMMcheck && bYYcheck) System.out.println("#" + i + " AMBIGUOUS");
            else if (!aMMcheck && !bMMcheck) System.out.println("#" + i + " NA");
            else {
                if (aMMcheck && bYYcheck)
                    System.out.println("#" + i + " MMYY");
                if (aYYcheck && bMMcheck)
                    System.out.println("#" + i + " YYMM");
            }
        }
    }
}
