package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2609 {


    static int euclid (int a, int b) {
        if (b == 0) return a;
        return euclid(b, a % b);
    }
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());

        String [] temp = br.readLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int gcd = euclid(Math.max(a, b), Math.min(a, b));
        int lcm = gcd * (a / gcd) * (b / gcd);
        System.out.println(gcd+"\n"+lcm);
    }
}
