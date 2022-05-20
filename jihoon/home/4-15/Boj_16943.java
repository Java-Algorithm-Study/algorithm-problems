import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16943 {
    private static int N;
    private static int[] num;
    private static int B;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    private static int max = -1;
    
    public static void dfs(int depth) {
        if (depth == N) {
            int newNum = Integer.parseInt(sb.toString());
            if (newNum < B && String.valueOf(newNum).length() == N) {
                max = Math.max(max, newNum);
            }
            return;
        }
    
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(num[i]);
            dfs(depth + 1);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine());
        String A = st.nextToken();
        N = A.length();
        visited = new boolean[N];
        num = new int[N];
        for (int i = 0; i < A.length(); i++) {
            num[i] = Integer.parseInt(String.valueOf(A.charAt(i)));
        }
        B = Integer.parseInt(st.nextToken());
        dfs(0);
        System.out.println(max);
    }
}
