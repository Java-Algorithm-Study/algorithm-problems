import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bf.readLine()) != null) {
            int[] sum = new int[4];
            var answer = new StringBuffer(4);

            // sum 배열에 순서대로 소문자, 대문자, 숫자, 공백 갯수를 넣어준다
            for (int i = 0; i < line.length(); i++) {
                char str = line.charAt(i);
                if (Character.isLowerCase(str)) {
                    sum[0]++;
                } else if (Character.isUpperCase(str)) {
                    sum[1]++;
                } else if (Character.isDigit(str)) {
                    sum[2]++;
                } else if (str == ' ') {
                    sum[3]++;
                }
            }

            for (int num : sum) {
                answer.append(String.valueOf(num));
                answer.append(" ");
            }

            System.out.println(answer);
        }


    }
}
