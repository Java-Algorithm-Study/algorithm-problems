import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_16198_refactoring {
    static int N;
    static List<Integer> list = new ArrayList<>();;
    static int max = Integer.MIN_VALUE;

    public static void dfs(int sum) {
        if (list.size() <= 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int x = list.get(i);
            int subCalc = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            dfs(sum + subCalc);
            list.add(i, x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));

        dfs(0);
        System.out.println(max);
    }
}

