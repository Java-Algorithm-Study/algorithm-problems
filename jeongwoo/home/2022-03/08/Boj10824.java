import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [10824] 네 수
 * https://www.acmicpc.net/problem/10824
 */

public class Boj10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] str = new String[4];

        while(st.hasMoreTokens()) {
            for (int i = 0; i < 4; i++) {
                str[i] = st.nextToken();
            }
        }

        String sum1 = str[0] + str[1];
        String sum2 = str[2] + str[3];

        long ans = Long.parseLong(sum1) + Long.parseLong(sum2);

        System.out.println(ans);



    }
}
