import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 너무 복잡하게 생각하지 않아도된다..
// dfs는 인자로 어떤 값을 줄지 고민하는 것이 어렵다.
public class boj_9095_BruteForce {
    static int cnt;
    static int N;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            cnt = 0;
            dfs(0);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int sum) {
        // 조건을 추가하여 가지치기
        if (sum == N) { // sum이 N과 같아지면 cnt++
            cnt++;
            return;
        }
        if (sum > N) return;
        for (int i = 1; i <= 3; i++) dfs(sum + i);
    }
}
