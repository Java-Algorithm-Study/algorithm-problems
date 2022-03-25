import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17087 {
    public static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(bf.readLine().split(" ")[1]);
        String[] n = bf.readLine().split(" ");
        int gcd = Math.abs(Integer.parseInt(n[0]) - s);
        for (int i = 1; i < n.length; i++) {
            gcd = getGCD(gcd, Math.abs(Integer.parseInt(n[i]) - s));
        }
        System.out.println(gcd);
    }
}