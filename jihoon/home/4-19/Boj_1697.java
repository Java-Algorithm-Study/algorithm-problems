import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {
    private static int N;
    private static int K;
    private static int[] map;
    
    public static int bfs(int i) {
        if (N == K) return 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
    
        while (!q.isEmpty()) {
            int x = q.poll();
            int nx1 = x + 1;
            int nx2 = x - 1;
            int nx3 = x * 2;
    
            if (nx1 < K + 1) {
                if (map[nx1] == 0) {
                    map[nx1] = map[x] + 1;
                    q.offer(nx1);
                }
            }
            if (nx2 >= 0) {
                if (map[nx2] == 0) {
                    map[nx2] = map[x] + 1;
                    q.offer(nx2);
                }
            }
            
            if (nx3 < K + 1) {
                if (map[nx3] == 0) {
                    map[nx3] = map[x] + 1;
                    q.offer(nx3);
                }
            }
     
            if (map[K] != 0) return map[K];
        }
        
        return map[K];
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[100001];
        System.out.println(bfs(N));
    }
}
