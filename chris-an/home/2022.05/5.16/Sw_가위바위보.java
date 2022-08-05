import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_가위바위보 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if ((A == 1 && B == 3) || (A == 3 && B == 1)) {
            if (A > B) System.out.println("B");
            else System.out.println("A");
        }else {
            if (A > B) System.out.println("A");
            else System.out.println("B");
        }
    }
}
