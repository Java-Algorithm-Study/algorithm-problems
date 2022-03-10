import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Pro_findPrime {

    static HashSet<Integer> hs = new HashSet();

    public static void dfs(String candidate, String remain) {
        if (!candidate.equals("")) hs.add(Integer.parseInt(candidate));

        for(int i = 0; i < remain.length(); i++) {
            dfs(candidate + remain.charAt(i), remain.substring(0, i) + remain.substring(i + 1));
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        dfs("", str);
        int cnt = 0;
        for (int i : hs) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}