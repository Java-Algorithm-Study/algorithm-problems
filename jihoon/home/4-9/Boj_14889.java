import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_14889 {
    public static int N;
    public static int[] temp;
    public static int[][] ability;
    public static int[] teamAbility;
    public static int min = Integer.MAX_VALUE;
    public static ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
    
    public static void dfs(int at, int depth) {
        if (depth == N / 2) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int n : temp) {
                list.add(n);
            }
            combinations.add(list);
            return;
        }
    
        for (int i = at; i < N; i++) {
            temp[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
    
    public static void calculateAbility() {
        for (int i = 0; i < combinations.size(); i++) {
            int sum = 0;
            for (int j = 0; j < N / 2; j++) {
                for (int k = j; k < N / 2; k++) {
                    int index1 = combinations.get(i).get(j);
                    int index2 = combinations.get(i).get(k);
                    sum += ability[index1][index2] + ability[index2][index1];
                }
            }
            teamAbility[i] = sum;
        }
    }
    
    public static void calculateMin() {
        for (int i = 0; i < teamAbility.length / 2; i++) {
            int diff = Math.abs(teamAbility[i] - teamAbility[teamAbility.length - 1 - i]);
            min = Math.min(min, diff);
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        ability = new int[N][N];
        temp = new int[N / 2];
        
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    
        dfs(0, 0);
        teamAbility = new int[combinations.size()];
        calculateAbility();
        calculateMin();
        System.out.println(min);
    }
}
