import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603{
    static StringBuilder answerSB = new StringBuilder();
    static final int LIMIT = 6;
    static boolean[] visited;
    static int[] line, group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            line = new int[LIMIT];
            group = new int[k];
            visited = new boolean[k];
            for (int i=0; i<k; i++)
                group[i] = Integer.parseInt(st.nextToken());
            dfs(0, 0);
            System.out.println(answerSB);
            answerSB.setLength(0);
        }
    }

    public static void dfs(int depth, int idx) {
        if (depth == LIMIT) {
            for (int n: line)
                answerSB.append(n).append(" ");
            answerSB.append("\n");
            return;
        }
        for (int i=idx; i<group.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                line[depth] = group[i];
//                if (depth != 0 && line[depth-1] > line[depth]) continue;   // 앞 수보다 더 작은 수일 경우 stop -> 깊이에 따라 index를 늘리면 됨
                dfs(depth+1, i+1);      // idx가 아니라 i...
                visited[i] = false;
            }
        }
    }
}