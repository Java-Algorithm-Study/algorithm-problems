package yeonsup.java.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_21919 {

    private boolean isPrime(Integer n) {
        for (int i = 2; i <= n / 2; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Long a = 1L;
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if(isPrime(number)) a *= number;
        }
        a = a == 1 ? -1 : a;

        System.out.println(a);
    }

    public static void main(String[] args) throws Exception{
        new Boj_21919().solution();
    }
}