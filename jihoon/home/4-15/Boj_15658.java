import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15658 {
    private static int[] nums;
    private static boolean[] visited;
    private static char[] temp;
    private static ArrayList<Character> operators = new ArrayList<>();
    private static int N;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    
    public static void addOperators(int j, int repetitive) {
        char sign = '+';
        if (j == 1) sign = '-';
        else if (j == 2) sign = '*';
        else if (j == 3) sign = '/';
        for (int i = 0; i < repetitive; i++) {
            operators.add(sign);
        }
    }
    
    public static void dfs(int depth) {
        if (depth == nums.length - 1) {
            findMinMax();
            return;
        }
        
        for (int i = 0; i < operators.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp[depth] = operators.get(i);
            dfs(depth + 1);
            visited[i] = false;
        }
    }
    
    public static void findMinMax() {
        int sum = 0;
        sum += nums[0];
        for (int i = 1; i < N; i++) {
            if (temp[i - 1] == '+') {
                sum += nums[i];
            } else if (temp[i - 1] == '-') {
                sum -= nums[i];
            } else if (temp[i - 1] == '*') {
                sum *= nums[i];
            } else if (temp[i - 1] == '/') {
                sum /= nums[i];
            }
        }
        max = Math.max(max, sum);
        min = Math.min(min, sum);
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        nums = new int[N];
        var st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            addOperators(i, Integer.parseInt(st.nextToken()));
        }
        
        temp = new char[N - 1];
        visited = new boolean[operators.size()];
        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }
}
