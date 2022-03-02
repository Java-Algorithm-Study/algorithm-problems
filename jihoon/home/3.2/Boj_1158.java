import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Boj_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        LinkedList<Integer> numbers = new LinkedList<>();
        StringBuffer ans = new StringBuffer();
        ans.append("<");

        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        for (int i = 0; i < n; i++) {
            numbers.add(i + 1);
        }

        while(numbers.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                numbers.add(numbers.removeFirst());
            }
            ans.append(numbers.removeFirst() + ", ");
        }
        ans.append(numbers.removeFirst() + ">");
        System.out.println(ans);
    }
}
