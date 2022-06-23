import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_11655 {

    static int ROT13 = 13;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Scanner sc = new Scanner(System.in);
        char [] input = br.readLine().toCharArray();
        //char [] input = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            int encrypt = input[i]+ROT13;

            if (input[i] >= 'a' && input[i] <= 'z') {
                if (encrypt > 'z')
                    sb.append((char)('a'-1 + (encrypt - 'z')));
                else
                    sb.append((char)encrypt);
            }else if (input[i] >= 'A' && input[i] <= 'Z') {
                if (encrypt > 'Z')
                    sb.append((char)('A'-1 + (encrypt - 'Z')));
                else
                    sb.append((char)encrypt);
            }else sb.append(input[i]);

        }
        System.out.println(sb);
    }
}
