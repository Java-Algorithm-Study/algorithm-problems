import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum {
    public static int[] ans;
    
    public static void bfs(int index, int n, int sum) {
        if (sum > n) return;
        
        if (sum == n) {
            ans[index]++;
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            bfs(index, n, sum + i);
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ans = new int[N];
        
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(bf.readLine());
            bfs(i, n, 0);
            System.out.println(ans[i]);
        }
    }
}
