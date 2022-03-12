import java.io.*;
import java.util.Arrays;


public class Boj_6588 {
    static boolean [] targetNumbers;
    public static void isPrime() {
        targetNumbers = new boolean[1000001];

        Arrays.fill(targetNumbers, true);
//        for(int i=2;i<=N;i++) {
//            targetNumbers[i] = true;
//        }
        for (int i = 2; i<=1000000; i++) {
            // 이미 확인된 건 넘기기
            if (!targetNumbers[i]) continue;
            // 배수 출발.
            for (int j = i * 2; j <= 1000000; j += i ) targetNumbers[j] = false;
        }
    }
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        isPrime();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int primeNum = Integer.MIN_VALUE;
            for (int i = 2; i <= n/2; i++) {
                if (targetNumbers[i] && targetNumbers[n-i]) {
                    primeNum = i;
                    break;
                }
            }

            if (primeNum > 0) bw.write(n + " = " + primeNum + " + " + (n-primeNum) + "\n");
            else bw.write("Goldbach's conjecture is wrong.\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}


/*

 시간 초과.

public class Main {
    public static String isPrime(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean [] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) {
                for (int j = i*i; j <= n; j+=i) prime[j] = false;
            }
        }
        for (int i = 2; i < n; i++) {
            if (true == prime[i]) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int k = i; k < list.size(); k++) {
                if (list.get(i)+list.get(k) == n) {
                    return n + " = " + list.get(i) + " + " + list.get(k);
                }
            }
        }
        return "Goldbach's conjecture is wrong.";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stop = 1;
        while (stop != 0) {
            stop = Integer.parseInt(br.readLine());
            if (stop!=0) {
                System.out.println(isPrime(stop));
            }
        }
    }
}

 */
