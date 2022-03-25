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

        // 진법으로 나누어주고 나머지를 넣어준다
        while (n != 0) {
            list.add(n % digit);
            n = (int) Math.floor(n / digit);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            int number = list.get(i);

            // 자릿수가 10 이상이면 알파벳으로 변환해주어야 한다
            if (number >= 10) {
                char ch = (char) (number + 55);
                sb.append(ch);
            // 자릿수가 10 미만이면 숫자 그대로 넣어준다
            } else {
                sb.append(list.get(i));
            }
        }
        System.out.println(sb);
    }
}
