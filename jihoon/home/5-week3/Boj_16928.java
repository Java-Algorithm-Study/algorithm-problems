import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16928 {
    static int count[] = new int[101];
    static int ladderAndSnake[] = new int[101];
    static boolean visited[] = new boolean[101];
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladderAndSnake[a] = b;
        }
        
        bfs();
    }
    
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 100) {
                System.out.println(count[cur]);
                return;
            }
            
            for (int i = 1; i <= 6; i++) {
                int x = cur + i;
                if (100 < x) continue;
                if (visited[x]) continue;
                visited[x] = true;
                
                if (ladderAndSnake[x] != 0) {
                    if (!visited[ladderAndSnake[x]]) {
                        q.offer(ladderAndSnake[x]);
                        visited[ladderAndSnake[x]] = true;
                        count[ladderAndSnake[x]] = count[cur] + 1;
                    }
                } else {
                    q.offer(x);
                    count[x] = count[cur] + 1;
                }
            }
        }
    }
    
}