package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Boj_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 5; i <= n ; i *= 5) {
            cnt += n / i;
        }

        System.out.println(cnt);
    }
}

/*

public class Main {

    static int value = 1;

    public static int factorial(int n) {
        if (n == 0) return value;
        value *= n;
        return factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = factorial(sc.nextInt());
        char [] ch = Integer.toString(N).toCharArray();

        int cnt = 0;
        for (int i = ch.length-1; i > 0; i--) {
            if (ch[i] == '0') cnt++;
            else break;
        }
        System.out.println(cnt);
    }
}
 */