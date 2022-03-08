import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_17298 {
    private static String advancedForLoop(String s) {
        String[] numbers = s.split(" ");
        StringBuffer ans = new StringBuffer();
        Stack<Integer> index = new Stack<>();
        index.push(1);

        for (int i = 0; i < numbers.length; i++) {
            int rightBigNumber = -1;
            int startIndex = 1;

            if (i != 0) {
                startIndex = (Integer.parseInt(numbers[i]) >= Integer.parseInt(numbers[i - 1])) ? index.peek() : i + 1;
            }
            for (int j = startIndex; j < numbers.length; j++) {

                if (Integer.parseInt(numbers[j]) > Integer.parseInt(numbers[i])) {
                    rightBigNumber = Integer.parseInt(numbers[j]);
                    index.push(j);
                    break;
                }
            }

            // 만약 오큰수가 없다면 인덱스를 하나만 증가시켜 바로 다음 문자열을 찾도록 한다
            if (rightBigNumber == -1) {
                index.push(i + 1);
            }
            ans.append(rightBigNumber);
            ans.append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    private static String forLoop(String s) {
        String[] numbers = s.split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < numbers.length; i++) {
            int rightBigNumber = -1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (Integer.parseInt(numbers[j]) > Integer.parseInt(numbers[i])) {
                    rightBigNumber = Integer.parseInt(numbers[j]);
                    break;
                }
            }
            ans.append(rightBigNumber);
            ans.append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        bf.readLine();
        String line = bf.readLine();
        System.out.println(advancedForLoop(line));
//        System.out.println(forLoop(line));
    }
}
// 9 3 5 2 7 10
// 9 6 5 2 7 10