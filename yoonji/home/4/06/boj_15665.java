import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// N과 M(11)
public class boj_15665 {
    private static int N, limit;
    private static int[] inputNums, line;
    private static void input() throws IOException {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        limit = scan.nextInt();
        line = new int[limit];
        inputNums = new int[N];
        for (int i = 0; i < N; i++) {
            inputNums[i] = scan.nextInt();
        }
        Arrays.sort(inputNums);
    }

    private static StringBuilder answerSB = new StringBuilder();
    private static void dfs(int depth) {
        if (depth == limit) {
            for (int i: line) answerSB.append(i).append(" ");
            answerSB.append("\n");
            return;
        }
        // 같은 깊이의 바로 이전 경우에서 이미 9를 입력했다면 9를 또 입력하지 않는다. ex) limit=2이고 line=[1,2]를 했다면 line=[1,2]를 또 추가하지 않는다.
        int sameDepthBeforeNum = 0;
        for (int i=0; i<N; i++) {
            if (sameDepthBeforeNum == inputNums[i]) continue;
            sameDepthBeforeNum = line[depth] = inputNums[i];
            dfs(depth + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        System.out.println(answerSB);
    }
    // 사용자 input을 처리하는 클래스
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}