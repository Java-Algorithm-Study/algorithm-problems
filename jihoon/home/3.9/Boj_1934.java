import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1934 {
    // 유클리드 호제법 O(log(n))
    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // O(n)
    private static int gcdSlow(int a, int b) {
        int smallNumber = Math.min(a, b);
        int bigNumber = Math.max(a, b);
        int ans = 1;
        for (int i = 2; i <= smallNumber; i++) {
            if (bigNumber % i == 0 && smallNumber % i == 0) {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            System.out.println((a * b) / gcdSlow(a, b));
        }
    }
}
