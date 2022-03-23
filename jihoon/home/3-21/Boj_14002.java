import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_14002 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
    
        int[] seq = new int[N];
        int[] dp = new int[N];
        String[] temp = bf.readLine().split(" ");
        var sb = new StringBuilder();
    
        for (int i = 0; i < temp.length; i++)
            seq[i] = Integer.parseInt(temp[i]);
    
        int max = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        
        sb.append(max + "\n");
    
        int value = max;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = N - 1; i >= 0; i--) {
            if (value == dp[i]) {
                stack.push(seq[i]);
                value--;
            }
        }
        
        while (!stack.empty()) sb.append(stack.pop()).append(" ");
        System.out.println(sb);
    }
}
