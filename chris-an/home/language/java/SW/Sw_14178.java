package language.java.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_14178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gardenLen = Integer.parseInt(st.nextToken());
            int waterRange = Integer.parseInt(st.nextToken());

            int result = gardenLen / ((waterRange * 2) + 1);
            boolean flag = gardenLen % ((waterRange * 2) + 1) == 0 ? true : false;
            if (flag) System.out.println("#" + i + " " + result);
            else System.out.println("#" + i + " " + (result+ 1));
        }
    }
}
