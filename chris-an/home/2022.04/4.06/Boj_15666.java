import java.io.*;
import java.util.*;

public class Boj_15666 {
    static int N, M;
    static int[] arr;
    static int[] inputDataArr;
    static StringBuilder sb = new StringBuilder();

    static void backtracking(int start, int depth) throws IOException {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        int beforeV = 0; // sort 를 하니깐, 동일한 숫자 값이 전 idx로 확인 가능합니다.
        for (int i = start; i < N; i++) {
            if (beforeV == inputDataArr[i]) continue;

            arr[depth] = inputDataArr[i];
            beforeV = arr[depth];

            backtracking(i, depth + 1);
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

        backtracking(0,0);

        System.out.println(sb);
    }
}