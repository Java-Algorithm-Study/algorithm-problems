import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10974 {
    public static int N;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void bfs(int depth) {
        
        if (depth == N) {
            for (int n : arr) {
                sb.append(n).append(' ');
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                bfs(depth + 1);
                visit[i] = false;
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        visit = new boolean[N];
        
        bfs(0);
        
        System.out.println(sb);
    }
}
