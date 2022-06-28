import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_11652 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
    
        for (int i = 0; i < N; i++) {
            long n = Long.parseLong(br.readLine());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Map.Entry<Long, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> {
            if (o1.getValue() - o2.getValue() == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });
    
        System.out.println(entryList.get(0).getKey());
    }
}
