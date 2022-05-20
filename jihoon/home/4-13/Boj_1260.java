import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1260 {
    private static int[][] map;
    private static boolean[] visit;
    private static int N;
    private static StringBuilder sb = new StringBuilder();
    
    public static void dfs(int i) {
        visit[i] = true;
        sb.append(i).append(' ');
        for (int j = 1; j <= N; j++) {
            if (map[i][j] == 1 && !visit[j]) {
                dfs(j);
            }
        }
    }
    
    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visit[i] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp).append(' ');
            for (int k = 1; k <= N; k++) {
                if (map[temp][k] == 1 && !visit[k]) {
                    q.add(k);
                    visit[k] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        dfs(V);
        sb.append("\n");
        Arrays.fill(visit, false);
        bfs(V);
        System.out.println(sb);
    }
}