import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_15666 {
    
    public static int N;
    public static int M;
    public static int[] numbers;
    public static int[] arr;
    public static LinkedHashSet<String> set = new LinkedHashSet<>();
    
    public static void dfs(int at, int depth) {
        if (depth == M) {
            var sb = new StringBuilder();
            for (int n : arr) {
                sb.append(n).append(' ');
            }
            set.add(sb.toString());
            return;
        }
        
        for (int i = at; i < N; i++) {
            arr[depth] = numbers[i];
            dfs(i, depth + 1);
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
        
        dfs(0, 0);
        for (String s : set) {
            System.out.println(s);
        }
        
        bf.close();
    }
}
