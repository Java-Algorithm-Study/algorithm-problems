import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15649 {
    private static ArrayList<String> arr = new ArrayList<>();
    
    public static void combination(String candidate, String others, int M) {
        if (candidate.length() == 2 * M) {
            arr.add(candidate.substring(1));
        }
    
        for (int i = 0; i < others.length(); i++) {
            combination(candidate + " " + others.charAt(i), others.substring(0, i) + others.substring(i + 1), M);
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        var sb = new StringBuilder(N);
    
        for (int i = 1; i <= N; i++) {
            sb.append(i);
        }

        combination("", sb.toString(), M);
        var ans = new StringBuilder(arr.size());
        for (String str : arr) {
            ans.append(str).append("\n");
        }
        
        System.out.println(ans);
    }
}
