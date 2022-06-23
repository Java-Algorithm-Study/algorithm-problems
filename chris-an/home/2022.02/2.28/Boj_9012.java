import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 괄호 9012 문제
public class Boj_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine()); // 몇 개를 입력할지 수를 나타냅니다.
        String [] array = new String[cnt]; // 괄호를 몇개 받을지 미리 공간할당해줍니다.

        for (int i = 0; i < cnt; i++) {
            array[i] = br.readLine(); // 1. 괄호를 담아줍니다.
        }

        for (int i = 0; i < cnt; i++) { // 2. 괄호 한 줄씩 비교로직을 시작합니다. (하나의 괄호 문자열의 길이는 2 이상 50 이하이다)
            int chk = 0;
            String [] word = array[i].split(""); // 3. 한 줄의 괄호를 하나씩 뽑습니다.

            // 이 로직은 (시작일땐 +, )닫아야할땐 - 즉, 한쌍이 되게끔하는 로직입니다.
            for (int k = 0; k < word.length; k++) {
                if(chk >= 0) {
                    if ("(".equals(word[k])) {
                        chk++;
                    } else if (")".equals(word[k])) {
                        chk--;
                    }
                }
            }

            // 쌍이 잘 맞을 경우는 chk 된 데이터가 0이어야하고,
            if (chk == 0) {
                System.out.println("YES");

            // 쌍이 잘 맞지 않을 경우, chk 된 데이터가 0이 아닐겁니다.
            }else {
                System.out.println("NO");
            }
        }
    }
}
