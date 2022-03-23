public class Pro_12921 {
    public static void main(String[] args) {
        int n = 10;
        var primes = new boolean[n + 1];
        primes[0] = primes[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 1; i < primes.length; i++) {
            if (!primes[i]) System.out.println(i);
        }
    }
}
