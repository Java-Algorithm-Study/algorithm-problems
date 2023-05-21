package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_16198 {
    static int N;
    //static int[] inputData;
    static ArrayList<Integer> inputData = new ArrayList<>();
    static boolean[] visited;
    static int[] idxArr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 1. 입력 에너지 구술 배열에 저장.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) inputData.add(Integer.parseInt(st.nextToken()));

        idxArr = new int[N-2];
        for (int i = 0; i < N-2; i++) idxArr[i] = i+1;

        visited = new boolean[N-2];
        int[] perm = new int[N-2];
        dfs(0, perm);
        System.out.println(max);
    }

    private static void dfs(int depth, int[] perm) {
        //base case
        if (depth == N - 2) {
            permCalc(perm);
            return;
        }

        //recur
        for (int i = 0; i < N - 2; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = idxArr[i];
                dfs( depth + 1, perm);
                visited[i] = false;
            }
        }
    }

    // 조합에 맞춰 연산 작업
    private static void permCalc(int[] perm) {
        int res = 0;
        ArrayList<Integer> copiedInputData = new ArrayList<>();
        //Collections.copy(temp, inputData); 초기화 작업 때문에 불필요한 코드라인 증가로 인해 x
        copiedInputData.addAll(inputData); // 깊은 복사
        int[] permCopy = Arrays.copyOf(perm, perm.length);

        for (int i = 0; i < permCopy.length; i++) {
            res += copiedInputData.get(permCopy[i] - 1) * copiedInputData.get(permCopy[i] + 1);
            copiedInputData.remove(permCopy[i]);
            for (int j = 0; j < permCopy.length; j++) {
                if (permCopy[i] < permCopy[j]) {
                    permCopy[j]--;
                }
            }
        }
        max = Math.max(max, res);
    }
}