import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * [1935] 후위 표기식 2
 * https://www.acmicpc.net/problem/1935
 */

public class Boj1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Double> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();
        double[] op = new double[n];

        for (int i = 0; i < n; i++) {
            op[i] = Double.parseDouble(br.readLine());
        }

        for (char x : ch) {
            if (x >= 'A' && x <= 'Z') {
                stack.push(op[x-'A']);
            }

            else {
                double sum = 0;
                double op1 = stack.pop();
                double op2 = stack.pop();

                switch (x) {
                    case '+' :
                        sum = op2 + op1;
                        stack.push(sum);
                        break;

                    case '-' :
                        sum = op2 - op1;
                        stack.push(sum);
                        break;

                    case '*' :
                        sum = op2 * op1;
                        stack.push(sum);
                        break;

                    case '/' :
                        sum = op2 / op1;
                        stack.push(sum);
                        break;
                }
            }
        }

        System.out.printf("%.2f",stack.peek());

    }
}
