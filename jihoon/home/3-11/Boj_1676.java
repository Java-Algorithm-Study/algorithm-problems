import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1676 {

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        System.out.println(n / 5 + n / 25 + n / 125);
    }
}
