package language.java.SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_최대수구하기 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            while(st.hasMoreTokens())  {
                int num = Integer.parseInt(st.nextToken());
                if(max < num) {
                    max = num;
                }
            }
            System.out.println("#" + i + " " + max);
        }
    }
}
