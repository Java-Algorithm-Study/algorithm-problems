import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// N과 M (3)
// 조건 : 증가 규칙, 중복 허용
public class boj_15651 {
    static int N, limit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        line = new int[limit];
        dfs(0, 1);
        System.out.println(answerSB);
    }

    static int[] line;
    static StringBuilder answerSB = new StringBuilder();
    private static void dfs(int depth, int num) {
        if (depth == limit) {
            for (int i:line)
                answerSB.append(i).append(" ");
            answerSB.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {   // 여기서 반복문을 돌려야 됨
            line[depth] = i+1;  // 배열의 index는 depth와 동일
            dfs(depth + 1, i + 1);  // 조건 수행
        }
    }
}
