import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971 {
    static int price[][];
    static boolean visit[];
    static int result, N, min;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        price = new int[N][N];
        visit = new boolean[N];
        min = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visit[0] = true;
        dfs(0, 0);
        
        System.out.println(min);
    }
    
    private static void dfs(int i, int depth) {
        if (depth == N - 1) {
            if (price[i][0] == 0) return;
            result = result + price[i][0];
            min = Math.min(min, result);
            result = result - price[i][0];
            return;
        }
        for (int j = 0; j < N; j++) {
            if (visit[j] || price[i][j] == 0) continue;

            result = result + price[i][j];
            if (result >= min) {
                result = result - price[i][j];
                continue;
            }
            visit[j] = true;
            dfs(j, depth + 1);
            result = result - price[i][j];
            visit[j] = false;
            
        }
        
    }
}