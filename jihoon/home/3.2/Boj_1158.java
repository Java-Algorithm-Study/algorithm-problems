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

        // LinkedList에 1~n까지 넣는다
        for (int i = 0; i < n; i++) {
            numbers.add(i + 1);
        }

        // LinkedList 길이가 1이 될때까지 반복한다
        while(numbers.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                // k - 1번째까지는 처음에 있던 값을 맨 뒤로 보낸다
                numbers.add(numbers.removeFirst());
            }
            // K번째 값은 제거 후 출력한다.
            ans.append(numbers.removeFirst() + ", ");
        }
        ans.append(numbers.removeFirst() + ">");
        System.out.println(ans);
    }
}
