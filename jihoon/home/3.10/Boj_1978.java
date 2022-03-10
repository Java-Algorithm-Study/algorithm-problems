import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1978 {
    private static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();
        int count = 0;
        String[] line = bf.readLine().split(" ");
        for (String num : line) {
            if (isPrime(Integer.parseInt(num))) {
                count++;
            }
        }

        System.out.println(count);
    }
}
