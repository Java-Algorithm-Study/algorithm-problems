package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_16964 {
    private static boolean[] visited;
    private static int N;
    private static int[] inputArr;
    private static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    private static int[] parent;
    private static StringTokenizer st;
    private static boolean flag;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        inputArr = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        isPossibleDfs(1, 0);

        if (flag) System.out.println(0);
        else System.out.println(1);
    }

    private static void isPossibleDfs(int x, int index) {
        if (flag) return;


        visited[x] = true;
        int count = 0;
        for (int next : adjList.get(x)) {
            if (!visited[next]) {
                visited[next] = true;
                parent[next] = x;
                count++;
            }
        }

        index++;
        for (int i = 0; i < count; i++) {
            if (parent[inputArr[index]] != x) {
                flag = true;
                return;
            }
            isPossibleDfs(inputArr[index], index);
        }
    }
}