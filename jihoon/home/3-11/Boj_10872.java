import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10872 {
    public static int factorialRecursion(int n) {
        if (n == 1) return n;
        return factorialRecursion(n - 1) * n;
    }

    public static int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        System.out.println(factorial(n));
    }
}
