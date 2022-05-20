import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15654 {
    private static int N;
    private static int M;
    private static int[] numbers;
    private static int[] arr;
    private static boolean[] visit;
    private static StringBuilder sb = new StringBuilder();
    
    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
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
        var st = new StringTokenizer(bf.readLine(), " ");
        var line = new StringTokenizer(bf.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        numbers = new int[N];
        visit = new boolean[N];
        arr = new int[M];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(line.nextToken());
        }
        Arrays.sort(numbers);
        
        dfs(0);
    
        System.out.println(sb);
    }
}
