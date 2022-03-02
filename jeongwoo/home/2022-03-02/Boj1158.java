import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * [1158] 요세푸스 문제
 * https://www.acmicpc.net/problem/1158
 */

public class Boj1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n+1; i++) {
            queue.offer(i);
        }

        int[] arr = new int[n];

        int idx= 0;

        sb.append("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                // k번째 수 앞에 있는 숫자들 뒤에 넣고, 큐에서 제거
                queue.offer(queue.peek());
                queue.remove();
            }

            // k번째 수 답안에 넣고 제거
            arr[idx] = queue.peek();
            queue.remove();
            idx++;
        }

        for (int i = 0; i < arr.length-1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[n-1]).append(">");

        System.out.println(sb);




    }
}
