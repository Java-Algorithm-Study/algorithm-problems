import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1373 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine();
        StringBuilder sb = new StringBuilder();

        // 세자리로 끊기도록 앞부분에 0을 더해준다
        if (num.length() % 3 == 1) num = "00" + num;
        if (num.length() % 3 == 2) num = "0" + num;

        for (int i = 0; i < num.length(); i += 3) {
            sb.append(Character.getNumericValue(num.charAt(i)) * 4 + Character.getNumericValue(num.charAt(i + 1)) * 2 + Character.getNumericValue(num.charAt(i + 2)));
        }

        System.out.println(sb);
    }
}
