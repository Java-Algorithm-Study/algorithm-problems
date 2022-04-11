import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_15661 {
    public static int N;
    public static ArrayList<Integer> temp = new ArrayList<>();
    public static int[][] ability;
    public static Map<Integer, ArrayList<ArrayList<Integer>>> teams = new HashMap<>();
    public static int min = Integer.MAX_VALUE;
    
    public static void dfs(int at, int depth) {
        if (depth == N - 1) return;
        if (2 <= depth && depth < N - 1) {
            ArrayList<Integer> list = new ArrayList<>(temp);
            ArrayList<ArrayList<Integer>> container = new ArrayList<>();
            var value = teams.getOrDefault(depth, container);
            value.add(list);
            teams.put(depth, value);
        }
        
        for (int i = at; i < N; i++) {
            temp.add(i);
            dfs(i + 1, depth + 1);
            temp.remove(temp.size() - 1);
        }
    }
    
    public static void calculateAbility() {
        for (int key : teams.keySet()) {
            int length = teams.get(key).size();
            for (int i = 0; i <= length / 2; i++) {
                var team1 = teams.get(key).get(i);
                var team2 = teams.get(N - key).get(length - i - 1);
                int team1Ability = 0;
                int team2Ability = 0;
                
                for (int j = 0; j < team1.size(); j++) {
                    for (int k = j + 1; k < team1.size(); k++) {
                        int index1 = team1.get(j);
                        int index2 = team1.get(k);
                        team1Ability += ability[index1][index2] + ability[index2][index1];
                    }
                }
    
                for (int j = 0; j < team2.size(); j++) {
                    for (int k = j + 1; k < team2.size(); k++) {
                        int index1 = team2.get(j);
                        int index2 = team2.get(k);
                        team2Ability += ability[index1][index2] + ability[index2][index1];
                    }
                }
                int diff = Math.abs(team1Ability - team2Ability);
                // 0이 나오면 가장 작은 최솟값이기 때문에 더 이상 계산할 필요가 없다
                // 시간을 조금 더 줄일 수 있다
                if (diff == 0) {
                    min = 0;
                    return;
                }
                min = Math.min(min, diff);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        ability = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        calculateAbility();
        System.out.println(min);
    }
}
