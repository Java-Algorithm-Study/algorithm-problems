import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9613 {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split(" ");
            long sum = 0;

            // 라인에 주어진 수들 중에서 2개 뽑기
            for (int k = 1; k < line.length; k++) {
                for (int n = k + 1; n < line.length; n++) {
                    sum += gcd(Integer.parseInt(line[k]), Integer.parseInt(line[n]));
                }
            }
            System.out.println(sum);
        }
    }
}
