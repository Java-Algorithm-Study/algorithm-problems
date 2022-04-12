import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1182 {
    private static int N;
    private static int S;
    private static int[] num;
    private static int count = 0;
    
    public static void dfs(int start, int depth, int sum) {
        if (depth > 0 && sum == S) {
            count++;
        }
    
        for (int i = start; i < N; i++) {
            dfs(i + 1, depth + 1, sum + num[i]);
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];
    
        var line = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(line.nextToken());
        }
        dfs(0, 0, 0);
        bf.close();
        System.out.println(count);
    }
}
