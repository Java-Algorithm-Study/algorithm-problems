import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String [] array = new String[cnt];

        for (int i = 0; i < cnt; i++) {
            array[i] = br.readLine();
        }


        for (int i = 0; i < cnt; i++) {
            int chk = 0;
            String [] word = array[i].split("");
            for (int k = 0; k < word.length; k++) {
                if(chk >= 0) {
                    if ("(".equals(word[k])) {
                        chk++;
                    } else if (")".equals(word[k])) {
                        chk--;
                    }
                }
            }
            if (chk == 0) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }


    }
}
