import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_큰놈작은놈같은놈 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            String result = "";
            if (num1 > num2) {
                result += ">";
            }else if(num1 < num2) {
                result += "<";
            }else {
                result += "=";
            }

            System.out.println("#" + i + " " + result);
        }

    }
}
