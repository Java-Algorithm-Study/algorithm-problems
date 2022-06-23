import java.io.*;
import java.util.*;

public class Boj_1707_bfs {
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
                isBipartite = bfs(i);

                // 중간에 아님이 판명된 경우 반복문을 멈춘다.
                if(!isBipartite) break;
            }

            // 이분 그래프 여부에 따라 출력
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    private static boolean bfs (int start) {
        // 전달된 번호부터 시작하여 BFS 탐색 수행
        color[start] = 1;

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);

        while (!qu.isEmpty()) {
            int node = qu.poll();

            for (int i : arrAdj[node]) {
                // 아직 방문되지 않은 정점이라면 큐에 넣고 현재 색상과 다른 색상으로 저장
                if(color[i] == 0) {
                    qu.offer(i);
                    color[i] = color[node] * -1;

                    // 이미 방문된 정점인 경우
                }else {
                    // 현재 정점의 동일한 색상이라면 이분 그래프가 아님
                    if (color[i] == color[node]) {
                        return false; // 이분그래프가 아님
                    }
                }
            }
        }
        return true; // 이분그래프
    }
}
