import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Programmers_42839 {

    static HashSet<String> hs = new HashSet<>();

    public static void recur(String candidate, String remain) {
        // base case 라고 불림.
        if (!candidate.equals("")) hs.add(candidate);
        for (int i = 0; i < remain.length(); i++){
            recur(candidate + remain.charAt(i), remain.substring(0, i) + remain.substring(i+1));
        }
    }

    public static boolean isPrime(int n) {
        // 0, 1 는 제외
        if (n < 2) return false;
        // true = 소수, false = 합성수
        boolean [] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;
        for (int i = 2; i*i <= n; i++) {
            // 소수가 아니라면?
            if (prime[i]) {
                for (int j = i*i; j <= n; j+=i) prime[j] = false;
            }
        }
        return prime[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        recur("", str);
        int cnt = 0;

        for (String s : hs) {
            if (isPrime(Integer.parseInt(s)))
                cnt++;
        }

        System.out.println(cnt);

    }
}
