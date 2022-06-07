import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_10816_2 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
    
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        var sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (map.get(number) != null) sb.append(map.get(number)).append(' ');
            else sb.append(0).append(' ');
        }
        System.out.println(sb);
    }
}
