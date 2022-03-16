import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11005 {
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int digit = Integer.parseInt(st.nextToken());
        var sb = new StringBuilder();

        if (n == 0)
            System.out.println(n);

        while (n != 0) {
            list.add(n % digit);
            n = (int) Math.floor(n / digit);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            int number = list.get(i);

            if (number >= 10) {
                char ch = (char) (number + 55);
                sb.append(ch);
            } else {
                sb.append(list.get(i));
            }
        }
        System.out.println(sb);
    }
}
