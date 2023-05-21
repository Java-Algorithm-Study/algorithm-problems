package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15657 {

    static int[] arr;
    static int N,M;
    static int[] inputDataArr;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        //base case
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        // recur
        for (int i = 0; i < N; i++) {
            arr[depth] = inputDataArr[i];
            if (depth != 0 && arr[depth] < arr[depth-1]) continue;
            dfs(depth + 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        inputDataArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputDataArr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(inputDataArr);

        dfs(0);

        System.out.println(sb);

    }
}
