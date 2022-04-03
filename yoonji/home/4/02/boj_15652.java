import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// N과 M (4)
// 조건 : 증가순, 비내림차순 (전 값보다 같거나 큰 값이 나와야 한다), 중복 허용
public class boj_15652 {
    static int N, limit;
    static int[] line;
    static StringBuilder answerSB = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        line = new int[limit];
        dfs(0);
        System.out.println(answerSB);
    }

    private static void dfs(int depth) {
        if (depth == limit) {
            for (int i:line) {
                answerSB.append(i).append(" ");
            }
            answerSB.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {   // 여기서 반복문을 돌려야 됨
            if (depth>0 && line[depth-1] > i+1) continue;    // 조건 수행, 그 전 depth의 값보다 현재 값이 작으면 넣지 않고 pass
            line[depth] = i+1;  // 배열의 index는 depth와 동일
            dfs(depth + 1); // 수는 깊이와 반복문에 따라 자동으로 처리됨
        }
    }
}
