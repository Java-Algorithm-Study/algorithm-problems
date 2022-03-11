import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17413 {
    private static String reverse(String s) {
        String[] words = s.split(" ");
        StringBuffer ans = new StringBuffer();
        for (String word : words) {
            StringBuffer sb = new StringBuffer(word);
            ans.append(sb.reverse());
            ans.append(" ");
        }
        ans.deleteCharAt(s.length());
        return ans.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        StringBuilder sb = new StringBuilder();

        // 라인 끝이 태그로 끝나지 않고 뒤집을 문자로 끝날 경우 '<'을 기준으로 뒤집을 문자를 경계삼는 방식에서 예외처리가 필요하다
        // 끝에 '<'를 추가해주어야 마지막에 뒤집을 문자들로 끝난 경우도 프로그램이 인지할 수 있다
        // ex) <a>1234로 끝난 경우 <a>1234<으로 만들어준다
        if (line.charAt(line.length() - 1) != '<') {
            line += "<";
        }

        StringBuffer ans = new StringBuffer();

        // isClosed 변수로 현재 문자열이 괄호 안에 있는지 밖에 있는지 구분한다
        boolean isClosed = true;

        // 현재 문자열이 괄호 밖에 있다면 toBeReversed 문자열에 추가된다
        StringBuilder toBeReversed = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {

            // Case1, 현재 문자열이 여는 괄호일 경우
            if (line.charAt(i) == '<') {
                ans.append(reverse(String.valueOf(toBeReversed)));
                isClosed = false;
                ans.append("<");
            // Case2, 현재 문자열이 닫는 괄호일 경우
            } else if (line.charAt(i) == '>') {
                toBeReversed.setLength(0);
                isClosed = true;
                ans.append(">");
            // Case3, 괄호 내부 문자인 경우
            } else if (!isClosed) {
                ans.append(line.charAt(i));
            // Case4, 괄호 밖에 있어 뒤집어야 할 문자인 경우, 뒤집어줄 문자에 더해준다
            } else {
                toBeReversed.append(line.charAt(i));
            }

        }

        // 앞서 예외처리를 위해 더해준 '<'를 제거해준다
        if (ans.charAt(ans.length() - 1) == '<') {
            ans.deleteCharAt(ans.length() - 1);
        }
        System.out.println(ans);

    }
}
