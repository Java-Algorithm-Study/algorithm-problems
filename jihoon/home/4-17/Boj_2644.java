import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2644 {
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static boolean[] visited;
    private static int[] answer;
    private static int A;
    private static int B;
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int x : list.get(temp)) {
                if (visited[x]) continue;
                q.offer(x);
                answer[x] = answer[temp] + 1;
                visited[x] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        var st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        bfs(A);
        int ans = answer[B] == 0 ? -1 : answer[B];
        System.out.println(ans);
    }
}
