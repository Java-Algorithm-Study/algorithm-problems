import java.io.*;
import java.util.*;

public class Boj_1339_2 {
    public static int[] alpha = new int[26];
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int x = 0; x < N; x++) {
            String line = br.readLine();
            int size = line.length();
            int base = (int) Math.pow(10, size - 1);
            for (int y = 0; y < size; y++) {
                alpha[line.charAt(y) - 'A'] += base;
                base /= 10;
            }
        }
        Arrays.sort(alpha);
        int ans = 0;
        for (int x = 25; x >= 17; x--) {
            ans += alpha[x] * (x - 16);
        }
        System.out.println(ans);
    }
}