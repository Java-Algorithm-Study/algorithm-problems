package diff1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw_연월일달력 {
    static int[] mmdd = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String num = br.readLine();
            String yyyy = num.substring(0, 4);
            String mm = num.substring(4, 6);
            String dd = num.substring(6);
            int mmCheck = Integer.parseInt(mm);
            int ddCheck = Integer.parseInt(dd);
            if (!(Integer.parseInt(yyyy) > 0 && Integer.parseInt(yyyy) < 10000)) {
                System.out.println("#" + i +" -1");
            }else if (!(Integer.parseInt(mm) > 0 && Integer.parseInt(mm) < 13)) {
                System.out.println("#" + i +" -1");
            }else if (!(0 < ddCheck && ddCheck <= mmdd[mmCheck])){
                System.out.println("#" + i +" -1");
            }else {
                System.out.println("#" + i + " " + yyyy+"/"+mm+"/"+dd);
            }

        }
    }
}
