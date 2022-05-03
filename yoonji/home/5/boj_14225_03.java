import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 부분수열의 합
public class boj_14225_03 {
    static boolean[] visited;
    static boolean[] isSubsequence;
    static int[] S;
    public static void main(String[] args) throws IOException {
        // 1. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        S = new int[N];
        int totalSum = 0;
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            totalSum += S[i];// 모든 원소의 합 (for visited 길이)
        }
        isSubsequence = new boolean[totalSum + 2];
        visited = new boolean[S.length];
        // 2. 자릿수만큼 dfs호출
        for (int i = 1; i <= N; i++) {
            dfs(0, i, 0, 0);
        }
        // 3. 최솟값 찾기
        findMinNum(totalSum);
    }
    private static void dfs(int depth, int limit, int idx, int sum) {
        if (depth == limit) {
            isSubsequence[sum] = true;
            return;
        }
//        if (idx >= S.length) return;
        for (int i=idx; i<S.length; i++) {
            if (!visited[i]) {
                sum+= S[i];
                visited[i]= true;
                dfs(depth+1, limit, i+1, sum);
                sum-= S[i];
                visited[i] = false;
            }
        }
    }
    private static void findMinNum(int totalSum) {
        for (int i = 1; i <= totalSum+1; i++) {
            if (!isSubsequence[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}