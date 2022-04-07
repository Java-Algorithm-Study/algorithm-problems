import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

// N과 M(12)
public class boj_15666 {
    private static int N, limit;
    private static int[] nums, line;
    private static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        limit = scan.nextInt();
        line = new int[limit];
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = scan.nextInt();
        Arrays.sort(nums);
    }

    private static StringBuilder answerSB = new StringBuilder();
    private static void recur(int depth, int idx) {
        if (depth == limit) {
            for (int i: line) answerSB.append(i).append(" ");
            answerSB.append("\n");
        } else {
            // 같은 깊이의 바로 이전 경우에서 이미 9를 입력했다면 9를 또 입력하지 않는다. ex) limit=2이고 line=[1,2]를 했다면 line=[1,2]를 또 추가하지 않는다.
            int sameDepthBeforeNum = 0;
            for (int i = idx; i < N; i++) {
                if (sameDepthBeforeNum == nums[i]) continue;
                sameDepthBeforeNum = line[depth] = nums[i];
                recur(depth + 1, i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        recur(0, 0);
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