import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Boj_11655 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer ans = new StringBuffer();
        String line = bf.readLine();
        for (int i = 0; i < line.length(); i++) {
            // 알파벳 문자인지 판별하기 위해 정규표현식 사용
            String pattern = "[a-zA-Z]";
            boolean regex = Pattern.matches(pattern, String.valueOf(line.charAt(i)));

            // 알파벳 문자일 때
            if (regex) {
                int ascii = (int) line.charAt(i) + 13;
                // 대문자와 소문자의 아스키코드가 다르므로 소문자와 대문자일 때 각각 z와 Z의 아스키 코드를 넣어주었다
                int identifier = (Character.isLowerCase(line.charAt(i))) ? 122 : 90;

                // 소문자와 대문자일 때 각각 z와 Z의 아스키 코드를 넘어서면 26을 빼주고 넘기지 않으면 그대로 아스키 코드를 넣어준다
                char shifted13 = (ascii > identifier) ? (char) (ascii - 26) : (char) (ascii);
                ans.append(shifted13);

            // 알파벳 문자가 아닐 때
            } else {
                ans.append(line.charAt(i));
            }
        }

        System.out.println(ans);
    }
}
