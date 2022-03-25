import java.io.IOException;
import java.util.ArrayList;

public class Boj_1463_Jihoon {
    private static ArrayList<Integer> list = new ArrayList<>();

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static boolean hasOnly2And3(int n) {
        if (n == 1) return true;
        while (!isPrime(n)) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }
        }
        if (n != 2 && n != 3) return false;
        return true;
    }

    private static void factorization(int n) {
        while (!isPrime(n)) {
            int divider = (n % 2 == 0) ? 2 : 3;
            list.add(divider);
            n = n / divider;
        }
        if (n != 1) list.add(n);
    }

    public static void main(String[] args) throws IOException {
//        var bf = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(bf.readLine());
        int n = 570;

        System.out.println(hasOnly2And3(n));

//        int count = 0;
//        while (!hasOnly2And3(n)) {
//            n--;
//            count++;
//        }
//
//        factorization(n);
//        System.out.println(count + list.size());
    }
}
