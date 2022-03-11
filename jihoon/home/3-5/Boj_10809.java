import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();

        int NUMBER_OF_ALPHABET = 26;
        StringBuffer ans = new StringBuffer();

        // 알파벳 배열을 만들어준다 물론 알파벳 하나하나 써도 되지만 26개를 쓰자니 너무 귀찮아서 아스키 코드로 넣어주었다
        char[] alphabets = new char[NUMBER_OF_ALPHABET];
        for (int i = 0; i < NUMBER_OF_ALPHABET; i++) {
            // 알파벳 a의 아스키 코드가 97번이다
            alphabets[i] = (char) (i + 97);
        }

        for (char alphabet : alphabets) {
            int index = -1;
            if (line.contains(String.valueOf(alphabet))) {
                index = line.indexOf(alphabet);
            }
            ans.append(index);
            ans.append(" ");
        }

        // 마지막 공백 제거
        ans.deleteCharAt(ans.length() - 1);
        System.out.println(ans);
    }
}
