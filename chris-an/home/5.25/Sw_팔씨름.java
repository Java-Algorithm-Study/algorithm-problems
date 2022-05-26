import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw_팔씨름 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();

            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'x') {
                    sum++;
                }
            }

            if (sum > 7) System.out.println("#" + tc + " " + "NO");
            else System.out.println("#" + tc + " " + "YES");
        }
    }
}
