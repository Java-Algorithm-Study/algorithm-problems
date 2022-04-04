import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15657 {
    
    public static int N;
    public static int M;
    public static int[] numbers;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void bfs(int at, int depth) {
        if (depth == M) {
            for (int n : arr) {
                sb.append(n).append(' ');
            }
            sb.append("\n");
            return;
        }
        
        for (int i = at; i < N; i++) {
            arr[depth] = numbers[i];
            bfs(i, depth + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        var line = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        arr = new int[M];
        
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(line.nextToken());
            numbers[i] = n;
        }
        Arrays.sort(numbers);
        
        bfs(0, 0);
        
        System.out.println(sb);
        
        bf.close();
    }
}
