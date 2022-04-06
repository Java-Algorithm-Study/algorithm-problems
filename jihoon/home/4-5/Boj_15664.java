import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_15664 {
    
    public static int N;
    public static int M;
    public static int[] numbers;
    public static int[] arr;
    public static boolean[] visit;
    public static int count = 0;
    public static LinkedHashSet<String> set = new LinkedHashSet<>();
    
    public static void bfs(int at, int depth) {
        if (depth == M) {
            var sb = new StringBuilder();
            for (int n : arr) {
                sb.append(n).append(' ');
            }
            set.add(sb.toString());
            return;
        }
        
        for (int i = at; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = numbers[i];
                bfs(i, depth + 1);
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
        arr = new int[M];
        visit = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(line.nextToken());
            numbers[i] = n;
        }
        Arrays.sort(numbers);
        
        bfs(0, 0);
        for (String s : set) {
            System.out.println(s);
        }
        
        bf.close();
    }
}
