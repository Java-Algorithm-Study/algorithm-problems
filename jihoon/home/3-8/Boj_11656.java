import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        String[] str = new String[line.length()];

        for (int i = 0; i < line.length(); i++) {
            str[i] = line.substring(i, line.length());
        }

        Arrays.sort(str);
        for (String string : str) {
            System.out.println(string);
        }
    }
}
