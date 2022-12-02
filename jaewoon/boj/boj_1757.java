package boj;

import java.io.*;


public class boj_1757 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (true){
            if(isPrime(n)){
                sb.append(String.valueOf(n));
                if(sb.toString().equals(sb.reverse().toString())){
                    break;
                }
                sb.setLength(0);
            }

            n++;
        }

        System.out.println(n);

    }
    static Boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}