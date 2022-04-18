import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16940 {
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static int[] output;
    private static boolean[] visited;
    private static int index = 1;
    private static boolean flag;
   
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
    
            Set<Integer> set = new HashSet<>();
            for (int child : list.get(temp)) {
                if (visited[child]) continue;
                set.add(child);
            }
            if (set.size() == 0) return;
            
            if (set.contains(output[index])) {
                int i = index++;
                q.offer(output[i]);
                visited[i] = true;
            } else {
                flag = true;
                return;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        output = new int[N];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            var st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        var st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (i == 0 && n != 1) {
                System.out.println(0);
                return;
            }
            output[i] = n;
        }
        bfs(1);
        
        if (flag) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
