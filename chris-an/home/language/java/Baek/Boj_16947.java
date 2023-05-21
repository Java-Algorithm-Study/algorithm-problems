package language.java.Baek;

import java.io.*;
import java.util.*;

public class Boj_16947 {

    static int N;
    static ArrayList<ArrayList<Integer>> adjArr = new ArrayList<>();
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        /*
            check 배열
                순환선에 속하지 않는 역은 '0' 저장
                순환선에 속한 역은 시작점에서 '해당 역까지 가는데 소요된 비용' 저장
         */
        check = new int[N + 1];

        // 지하철 노선 선언
        for(int i = 0; i < N + 1; i++){
            adjArr.add(new ArrayList<>());
        }

        // 지하철 노선 초기화
        for(int i = 1; i < N + 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjArr.get(x).add(y);
            adjArr.get(y).add(x);
        }

        // 순환선 탐색 (사이클)
        dfs(1, -1, 1);


        int[] distance = new int[N + 1]; // 순환점에서 지선 역(노드)의 거리를 구하여 담습니다.

        for (int i = 1; i < N + 1; i++) {
            // 지선만을 in 하게끔, 노드의 인접 노드가 2개를 초과하게되면 순환이 아니다.
            if(adjArr.get(i).size() > 2 && check[i] != 0){
                Queue<Integer> qu = new LinkedList<>();
                qu.offer(i);
                while (!qu.isEmpty()) {
                    int node = qu.remove();

                    for (int adjNode : adjArr.get(node)) {
                        // 순환선 포함 역 또는 이미 방문한 지선 역은 pass
                        if (check[adjNode] != 0 || distance[adjNode] != 0) continue;

                        qu.offer(adjNode);
                        distance[adjNode] = distance[node] + 1; // 떨어진 정도 저장
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N + 1; i++){
            sb.append(distance[i]).append(' ');
        }

        System.out.println(sb);
    }

    public static boolean dfs(int node, int beforeNode, int cnt) {
        // base case
        /*
            사이클(순환선) 발견 시 true 로 리턴
            그리고, 이 떄 사이클은 발견했으니, 사이클에 포함되지 않는 부분은 0으로 채움.
            why? 현재 node 가 순환점의 시작점이다.
         */
        if(check[node] != 0) {
            for (int i = 1; i < N + 1; i++) {
                if(check[i] < check[node]) check[i] = 0;
            }
            return true;
        }

        // dfs 탐색
        for(int adjNode : adjArr.get(node)) {
            if(adjNode == beforeNode) continue; // 직전에 방문한 역은 방문x

            // dfs 재귀 루프 구현 부분
            check[node] = cnt;
            if(dfs(adjNode, node, cnt+1)) return true;
            check[node] = 0;

        }
        return false;
    }
}