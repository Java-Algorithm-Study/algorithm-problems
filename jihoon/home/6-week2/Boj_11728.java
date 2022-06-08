import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11728 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);
        var sb = new StringBuilder();
        for (int n : list) {
            sb.append(n).append(' ');
        }
        System.out.println(sb);
    }
}
