import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2675 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            var ans = new StringBuffer();
            String[] str = bf.readLine().split(" ");
            int repeat = Integer.parseInt(str[0]);
            String line = str[1];
            for (int j = 0; j < line.length(); j++) {
                for (int k = 0; k < repeat; k++) {
                    ans.append(line.charAt(j));
                }
            }
            System.out.println(ans);
        }
    }
}
