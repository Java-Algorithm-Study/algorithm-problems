import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10824 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bf.readLine().split(" ");
        System.out.println(Long.parseLong(numbers[0] + numbers[1]) + Long.parseLong(numbers[2] + numbers[3]));
    }
}
