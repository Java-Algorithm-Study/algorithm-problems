import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj_10971 {
    private static boolean[] visited;
    private static int[] line;
    private static long minCost = Long.MAX_VALUE;
    private static int cost=0;
    private static int N;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N];
        line = new int[N];
        // cost = line = new int[N];  금지..
        StringTokenizer st;
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=N; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(minCost);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            if (map[line[N-1]][line[0]] == 0) return;   // 마지막에서 출발 도시로 가는 길이 없다면 stop
            cost += map[line[N-1]][line[0]];    // 다시 섬에 도착하는 경우를 추가
            minCost = Math.min(minCost, cost);
            cost -= map[line[N-1]][line[0]];
            return;
        }

        for (int i=1; i<=N; i++) {   // 번호는 1~N
            // 갈 수 없는 map으로 가려할 경우 stop
            if (depth>0 && map[line[depth-1]][i] == 0) continue;
            if (!visited[i-1]) {
                visited[i-1] = true;
                line[depth] = i;
                if (depth!=0)   // 도시 이동비용 추가 (단, 첫 도시일 경우 이동비용 추가 X)
                    cost += map[line[depth-1]][i];
                // 수정. 현재 minCost보다 커지는 순간이 왔을 때 바로 가지치기 -> 제거. 현재는 클 수 있어도 그 후에 작은 값이 나올 수 있기 때문이라 생각함.

                dfs(depth+1);
                visited[i-1] = false;
                if (depth!=0) cost -= map[line[depth-1]][i];
            }
        }
    }
}