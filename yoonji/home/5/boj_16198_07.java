import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16198_07 {
    static List<Integer> energys = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            energys.add(Integer.parseInt(st.nextToken()));
        }
        dfs(0);
        System.out.println(maxSum);
    }
    static int maxSum = Integer.MIN_VALUE;
    private static void dfs(int sum) {
        if (energys.size() <= 2) {  // 3개 이상 있어야 아래 로직이 가능
            maxSum = Math.max(maxSum, sum);
            return;
        }
        for (int i=1; i<energys.size()-1; i++) {
            int energy = energys.get(i);
            int multi = energys.get(i-1) * energys.get(i+1);
            energys.remove(i);
            dfs(sum+multi);
            energys.add(i, energy);
        }
    }
}
