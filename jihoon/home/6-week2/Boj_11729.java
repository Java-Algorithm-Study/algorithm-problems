import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11729 {
    private static StringBuilder sb = new StringBuilder();
    private static int count;
    
    public static void recursion(int n, int from, int to, int other) {
        if (n == 0) return;
        count++;
        recursion(n - 1, from, other, to);
        sb.append(from).append(' ').append(to).append("\n");
        recursion(n - 1, other, to, from);
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        recursion(n, 1,3, 2 );
        
        StringBuilder ans = new StringBuilder();
        ans.append(count).append("\n").append(sb);
        System.out.println(ans);
    }
}
