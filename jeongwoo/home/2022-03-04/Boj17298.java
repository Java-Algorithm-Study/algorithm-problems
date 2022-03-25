import java.util.Scanner;
import java.util.Stack;

/**
 * [17298] 오큰수
 * https://www.acmicpc.net/problem/17298
 */

public class Boj17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }
                stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
