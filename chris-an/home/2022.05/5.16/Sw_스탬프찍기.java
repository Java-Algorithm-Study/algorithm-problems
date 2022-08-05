import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw_스탬프찍기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append('#');
        }
        System.out.println(sb);
    }
}
