import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10819 {
    public static int[] numbers;
    public static int N;
    public static int[] arr;
    public static boolean[] visit;
    public static int ans = 0;
    
    public static void dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 1; i < arr.length; i++) {
                sum += Math.abs(arr[i - 1] - arr[i]);
            }
            if (sum > ans) ans = sum;
            return;
        }
    
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = numbers[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        visit = new boolean[N];
        numbers = new int[N];
        
        var st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    
        dfs(0);
        
        System.out.println(ans);
    }
}
