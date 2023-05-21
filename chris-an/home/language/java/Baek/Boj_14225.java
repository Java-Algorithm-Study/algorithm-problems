package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Boj_14225{
    static int N;
    static int[] inputData;
    static boolean[] visited = new boolean[2_000_000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inputData = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) inputData[i] = Integer.parseInt(st.nextToken());

        sumSubsequence(0,0); // dfs

        int answer = 1; // 0은 x, sumSubsequence sum 값이 0이 나와서 그럼.
        while(visited[answer]) answer++; // 방문처리

        System.out.println(answer);
    }

    static void sumSubsequence(int depth, int sum){
        if(depth == N) { // 해당 depth 에 도달하면, visited 처리.
            visited[sum] = true;
            return;
        }

        sumSubsequence(depth + 1,sum + inputData[depth]); // depth 3까지 들어가기 위함.
        sumSubsequence(depth + 1, sum); // 다시 back
    }
}