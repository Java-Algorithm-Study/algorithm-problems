import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * [17299] 오등큰수
 * https://www.acmicpc.net/problem/17299
 */


public class Boj17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] cnt = new int[1000001];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && cnt[arr[stack.peek()]] < cnt[arr[i]]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }



        for (int i : ans) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());

    }
}
