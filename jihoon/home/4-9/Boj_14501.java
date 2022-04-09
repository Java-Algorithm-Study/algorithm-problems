import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_14501 {
    public static int N;
    public static int[][] map;
    public static ArrayList<Integer> temp = new ArrayList<>();
    public static int maxPrice = 0;
    
    public static void dfs(int start, int depth) {
        if (1 <= depth) {
            int price = 0;
            for (int i : temp) {
                price += map[i][1];
            }
            maxPrice = Math.max(maxPrice, price);
        }
    
        for (int i = start; i < N; i++) {
            // 그전에 뽑은 인덱스 번호와 뽑으려는 인덱스 번호의 차이가 상담일보다 작을 때 continue
            if (depth > 0 && map[temp.get(depth - 1)][0] > i - temp.get(depth - 1)) {
                continue;
            }
            
            // 현재 뽑으려는 상담일이 퇴사 날짜보다 클 때
            if (i + map[i][0] > N) {
                continue;
            }
            
            temp.add(i);
            dfs(i + 1, depth + 1);
            temp.remove(temp.size() - 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(bf.readLine(), " ");
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        bf.close();
        dfs(0, 0);
        System.out.println(maxPrice);
    }
}
