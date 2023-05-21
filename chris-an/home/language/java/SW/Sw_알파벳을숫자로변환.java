package language.java.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw_알파벳을숫자로변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            sb.append(line.charAt(i) - 64).append(' ');
        }
        System.out.println(sb);
    }
}
