import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2745 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        String input = st.nextToken();
        int type = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            // 자리수의 수가 숫자면 그 숫자 그대로 Integer.parseInt()에 넣어주고 알파벳이면 아스키코드를 이용한다
            int n = (Character.getType(input.charAt(i)) == 9) ? Integer.parseInt(String.valueOf(input.charAt(i))) : ((int) input.charAt(i)) - 55;
            sum += n * (Math.pow(type, input.length() - i - 1));
        }
        System.out.println(sum);
    }

}
