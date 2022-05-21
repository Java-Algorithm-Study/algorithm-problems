import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_14226 {
    private static int N;
    private static int[] map;
    
    public static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
    
        while (!q.isEmpty()) {
            int x = q.poll();
            int nx1 = x;
            int nx2 = 2 * x;
            int nx3 = x - 1;
            
            if (nx1 <= N) {
                if (map[nx1] == 0) {
                    map[nx1] = map[x] + 2;
                    q.offer(nx1);
                }
            }
            
            if (nx3 > 0) {
                if (map[nx3] == 0) {
                    map[nx3] = map[x] + 1;
                    q.offer(nx3);
                }
            }
            if (map[N] != 0) return map[N];
        }
        return map[N];
    }
    
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[1001];
        System.out.println(bfs());
    }
}
