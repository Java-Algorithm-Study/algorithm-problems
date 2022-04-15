import java.io.*;
import java.util.*;

public class Boj_1707_dfs {
    static int V; // 정점
    static int E; // 간선
    static ArrayList<Integer>[] arrAdj;
    static int[] color;
    static boolean isBipartite = true; // bfs 탐색을 통해 이분 그래프인지 체크

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        // 테스트 케이스 수행
        while(K-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            // 색상 정보 초기화
            color = new int[V + 1];
            // 그래프 인접 리스트
            arrAdj = new ArrayList[V + 1];
            for (int i = 0; i < V + 1; i++) {
                arrAdj[i] = new ArrayList<>();
            }


            // 양방향 간선 정보 세팅
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arrAdj[x].add(y);
                arrAdj[y].add(x);
            }

            for(int i = 1; i < V + 1; i++){
                if(color[i] != 0) continue; // 이미 방문 완료된 정점이면 넘어간다.
                isBipartite = dfs(i, 1);

                // 중간에 아님이 판명된 경우 반복문을 멈춘다.
                if(!isBipartite) break;
            }

            // 이분 그래프 여부에 따라 출력
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }
    private static boolean dfs(int node, int col){
        color[node] = col;
        int nextCol = col * -1;

        boolean result = true;
        for (int i : arrAdj[node]) {

            // 아직 방문되지 않은 경우
            if (color[i] == 0)
                result = dfs(i, nextCol);
            else
            if(color[i] == color[node]) return false;


            // false 를 반환 받았다면 바로 되돌아간다.
            if (!result) return false;
        }
        return true;
    }
}
