package diff1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_홀수만더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if ((num % 2) == 1) {
                    sum += num;
                }
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}
