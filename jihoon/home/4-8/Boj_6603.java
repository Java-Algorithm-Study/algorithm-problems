import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_6603 {
    public static final int M = 6;
    public static StringBuilder sb = new StringBuilder();
    
    public static void dfs(int n, String[] numbers, String[] arr, int at, int depth) {
        if (depth == M) {
            for (String s : arr) {
                sb.append(s).append(' ');
            }
            sb.append("\n");
            return;
        }
    
        for (int i = at; i < n; i++) {
            arr[depth] = numbers[i];
            dfs(n, numbers, arr, i + 1, depth + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!(line = bf.readLine()).equals("0")) {
            String[] s = line.split(" ");
            int n = Integer.parseInt(s[0]);
            String[] arr = new String[M];
            String[] numbers = Arrays.copyOfRange(s, 1, s.length);
            dfs(n, numbers, arr, 0, 0);
            sb.append("\n");
        }
    
        System.out.println(sb);
    }
}
