package language.java.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Sw_문자열나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();
            String previousCharValue = "";
            String currentCharValue = "";
            int cnt = 0;
            for (int i = 0; i < line.length(); i++) {
                currentCharValue += line.charAt(i);
                if (!currentCharValue.equals(previousCharValue)) {
                    previousCharValue = currentCharValue;
                    currentCharValue = "";

                    cnt++;
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}