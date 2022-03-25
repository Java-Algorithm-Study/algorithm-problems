import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2004 {
    static long fivePower(long num) {
        int count = 0;

        while(num >= 5) {
            count += num / 5;
            num /= 5;
        }
        return count;
    }

    static long twoPower(long num) {
        int count = 0;

        while(num >= 2) {
            count += num / 2;
            num /= 2;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        long count5 = fivePower(n) - fivePower(n - r) - fivePower(r);
        long count2 = twoPower(n) - twoPower(n - r) - twoPower(r);

        System.out.println(Math.min(count5, count2));

    }
}
