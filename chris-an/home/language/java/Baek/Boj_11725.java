package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11725 {
    static int N;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int[] parentList;


    static void bfs(){
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(1);
        parentList[1] = 1;

        while (!qu.isEmpty()) {
            int parent = qu.poll();

            for (int i : adjList.get(parent)) {
                if (parentList[i] == 0) {
                    parentList[i] = parent;
                    qu.offer(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parentList = new int[N + 1];
        // 초기화
        for (int i = 0; i < N + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        // 인접리스트 세팅
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        bfs();

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parentList[i]);
        }
    }
}
