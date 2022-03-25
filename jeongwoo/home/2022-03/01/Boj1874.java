import java.util.*;

/**
 * [1874] 스택 수열
 * https://www.acmicpc.net/problem/1874
 */

public class Boj1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (input[i] > idx) {
                for (int j = idx+1; j <= input[i]; j++) {
                    stack.push(j);
                    idx++;
                    sb.append("+").append("\n");
                }
            }

            if (stack.peek() == input[i]) {
                stack.pop();
                sb.append('-').append('\n');
            }

            if (!stack.isEmpty() && stack.peek() > input[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
        
    }
}
