import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boj_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                sb.append(i).append('\n');
                N /= i;
            }
        }
        if (N != 1) {
            sb.append(N);
        }
        System.out.println(sb);
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//public class Boj_11653 {
//    private static ArrayList<Integer> list = new ArrayList<>();
//    private static ArrayList<Integer> prime = new ArrayList<>();
//    private static final int N = 10_000_000;
//
//    private static boolean isPrime(int n) {
//        for (int i = 2; i * i <= n; i++) {
//            if (n % i == 0) return false;
//        }
//        return true;
//    }
//
//    private static void makePrime() {
//        boolean[] helper = new boolean[N + 1];
//        helper[0] = helper[1] = true;
//        for (int i = 2; i * i <= N; i++) {
//            if (!helper[i]) {
//                for (int k = i * i; k <= N; k += i) {
//                    helper[k] = true;
//                }
//            }
//        }
//        for (int i = 2; i < helper.length; i++) {
//            if (!helper[i]) prime.add(i);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        var bf = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(bf.readLine());
//        makePrime();
//        int i = 0;
//
//
//        while (!isPrime(n)) {
//            while (n % prime.get(i) != 0) {
//                i++;
//            }
//            list.add(prime.get(i));
//            n = n / prime.get(i);
//        }
//        list.add(n);
//
//        if (n == 1) System.out.println();
//        else {
//            for (int item : list) {
//                System.out.println(item);
//            }
//        }
//    }
//}
