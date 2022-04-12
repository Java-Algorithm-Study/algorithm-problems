import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2529 {
    private static int N;
    private static String[] sign;
    private static int[] temp;
    private static boolean[] visit;
    private static long min = Long.MAX_VALUE;
    private static long max = Long.MIN_VALUE;
    
    public static void dfs(int depth) {
        if (depth == N + 1) {
            var sb = new StringBuilder(N + 1);
            for (int n : temp) {
                sb.append(n);
            }
            long n = Long.parseLong(sb.toString());
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }
        
        for (int i = 0; i < 10; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            temp[depth] = i;
            if (check(depth)) {
                dfs(depth + 1);
            }
            visit[i] = false;
        }
    }
    
    public static boolean check(int i) {
        if (i == 0) return true;
        
        if ("<".equals(sign[i - 1])) {
            return temp[i - 1] < temp[i];
        } else {
            return temp[i - 1] > temp[i];
        }
    }

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        sign = bf.readLine().split(" ");
        visit = new boolean[10];
        temp = new int[N + 1];
        dfs(0);
        String maxAns = String.valueOf(max);
        String minAns = String.valueOf(min);

        if (maxAns.length() == N) {
            System.out.println("0" + max);
        } else {
            System.out.println(max);
        }
        if (minAns.length() == N) {
            System.out.println("0" + min);
        } else {
            System.out.println(min);
        }
    }
}
