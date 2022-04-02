import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj_15652 {
    
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void dfs(int N, int M, int depth, int at) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for (int i = at; i < N; i++) {
            arr[depth] = i + 1;
            dfs(N, M, depth + 1, i);
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        dfs(N, M, 0, 0);
        System.out.println(sb);
        
    }
}