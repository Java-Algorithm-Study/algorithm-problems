import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_12101 {
    private static int N;
    private static int K;
    private static ArrayList<Integer> temp = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    private static int count;
    
    public static void dfs(int depth, int sum) {
        if (sum > N) return;
        
        if (sum == N) {
            count++;
            if (count == K) {
                for (int n : temp) {
                    sb.append(n).append('+');
                }
            }
            return;
        }
    
        for (int i = 1; i <= 3; i++) {
            temp.add(i);
            dfs(depth + 1, sum + i);
            temp.remove(temp.size() - 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        dfs(0, 0);
        
        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
