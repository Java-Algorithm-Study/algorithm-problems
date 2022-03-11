import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//후위 표기식2
public class boj_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] oper = br.readLine().toCharArray();
        double[] num = new double[N];
        Map<Character, Double> map = new HashMap<>();
        for (char c : oper) {
            if (Character.isAlphabetic(c) && !map.containsKey(c)) map.put(c, map.getOrDefault(c, Double.parseDouble(br.readLine())));    // 없으면 입력받아서 put
        }

        double rightNum =.0;
        double leftNum =.0;
        double answer = .0;
        ArrayList<Double> stack = new ArrayList<Double>();

        for (char c : oper) {
            if (map.containsKey(c)) stack.add(map.get(c));
            else if (stack.size() >= 1) {
                rightNum = stack.remove(stack.size() - 1);
                leftNum = stack.remove(stack.size() - 1);
                if (c == '*') answer = leftNum * rightNum;
                else if (c == '+') answer = leftNum + rightNum;
                else if (c == '-') answer = leftNum - rightNum;
                else answer = leftNum / rightNum;

                stack.add(answer);
            }
        }
        String ret = String.format("%.2f", stack.get(0));
        System.out.println(ret);
    }
}