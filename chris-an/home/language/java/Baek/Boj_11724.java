package language.java.Baek;

import java.io.*;
import java.util.*;

public class Boj_11724 {

    static int N,M; // 정점, 간선
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean visited[];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1]; // 방문체크는 1~N(정점)까지

        // 초기화 => 인접리스트 N+1 인덱스 맞추기 위해서 <= N+1로 세팅
        for(int i = 1; i <= N + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        // 양방향 세팅
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }


        // 간선의 양 끝점이 1부터 N까지
        for(int i = 1; i < N + 1; i++) {
            // 방문한 요소가 아닐 경우 시작하고
            if(!visited[i]) {
                dfs(i);
                count++; // dfs 돌고오면, 한 개 추가.
            }
        }
        System.out.println(count);
    }

    static void dfs(int node){

        // 다 방문해서 방문할 요소가 없을 경우, return 해서 빠져 나옵니다.
        if(visited[node]) {
            return;
        }

        visited[node] = true;
        // 인접리스트를 확인하여, 방문 체크
        for(int i : adjList.get(node)){
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}