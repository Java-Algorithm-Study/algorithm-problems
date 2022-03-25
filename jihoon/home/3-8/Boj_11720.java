import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11720 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        bf.readLine();
        String[] line = bf.readLine().split("");
        for (String num : line) {
            sum += Integer.parseInt(num);
        }
        System.out.println(sum);
    }
}
