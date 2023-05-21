package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Boj_1212 {
    static char[] twoCharArr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String eight = br.readLine();
        char[] eightCharArr = eight.toCharArray();

        int twoLen = getPossibleDigitNumber(eightCharArr);
        twoCharArr = new char[twoLen];

        int idx = twoLen - 1;
        for(int i = eight.length() - 1; i >= 0; i--) {
            char num = eightCharArr[i];
            idx = getTwoDigitNumber(num, idx);
        }
        System.out.print(new String(twoCharArr));
    }
    static int getTwoDigitNumber(char ch, int nowIndex) {
        int num = ch - '0';

        for(int i = 0; i < 3; i++) {
            twoCharArr[nowIndex--] = (char) ((num % 2) + '0');
            num /= 2;
            if(nowIndex < 0) break;
        }
        return nowIndex;
    }

    static int getPossibleDigitNumber(char[] charArr) {
        int len = charArr.length * 3;
        if(len == 0) return 0;

        int firstNum = charArr[0] - '0';

        if(firstNum / 4 > 0) return len;
        if(firstNum / 2 > 0) return len - 1;
        return len - 2;
    }
}

/*

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        for (int i = 0; i < N.length(); i++) {
            String dd = Integer.toBinaryString(N.charAt(i) - '0');

            if (dd.length() == 2 && i != 0) dd = "0" + dd;
            else if (dd.length() == 1 && i != 0) dd = "00" + dd;
            sb.append(dd);
        }
        System.out.println(sb);
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] N = br.readLine().split("");

        for (int i = 0; i < N.length; i++) {
            int tmp = Integer.parseInt(N[i]);
            String dd = "";
            while(true) {
                dd += "" + tmp % 2;
                tmp = tmp / 2;
                if (tmp == 0) break;
            }

            if (dd.length() == 2 && i != 0) {
                dd = dd + "0";
            }
            if (dd.length() == 1 && i != 0) {
                dd = dd + "00";
            }

            for (int j = dd.length()-1; j >= 0; j--) {
                sb.append(dd.charAt(j));
            }
        }
        System.out.println(sb);
    }
}
*/

