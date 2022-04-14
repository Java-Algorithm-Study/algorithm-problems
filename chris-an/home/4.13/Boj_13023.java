import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    ABCDE 인접리스트 사용
 */
public class Boj_13023 {

    static boolean seekRoute = false;
    static ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        // N-1 이라, 인접 그래프에서 자료구조 초기화할 때 +1 해주는 걸 안해주어도 됨.
        for (int i = 0; i < N; i++) {
            arrList.add(new ArrayList<>());
        }

        // 인접리스트 양방향 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 양방향을 미리 편하게 이런식으로 처리합니다.
            arrList.get(x).add(y);
            arrList.get(y).add(x);
        }


        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            dfs(i, 1);

            // dfs 에서 처리가 됐을 시, 추가적으로 루프를 돌 필요 없음.
            if (seekRoute) break;
        }
        System.out.println(seekRoute ? 1 : 0);
    }

    static void dfs(int node, int cnt) {

        // 5명 탐색. 노드 cnt 5 (A B C D E)
        if (cnt == 5) {
            seekRoute = true;
            return;
        }

        visited[node] = true;
        for (int adjV : arrList.get(node)) {
            if (!visited[adjV])
                dfs(adjV, cnt + 1);


            if (seekRoute) return;
        }

        // 일직선이 아닐 경우, 즉 저장한 인접 노드가 없을 경우 재탐색을 위해 노드 false 처리
        visited[node] = false;
    }
}