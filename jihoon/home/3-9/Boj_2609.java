import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2609 {

    // 유클리드 호제법
    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int gcd_slow(int a, int b) {
        int smallNumber = Math.min(a, b);
        int bigNumber = Math.max(a, b);

        for (int i = smallNumber; i > 0; i--) {
            if (bigNumber % i == 0 && smallNumber % i == 0) {
                return i;
            }
        }
        return 1;
    }

    // 두 자연수 a, b에 대하여 최소 공배수는 두 수의 곱을 최대공약수로 나눈 값과 같다
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = gcd(a, b);
        int lcm = (a * b) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
