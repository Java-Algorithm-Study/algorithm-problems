import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1759 {
    public static int L;
    public static int C;
    public static String[] s;
    public static String[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static final List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
    
    public static void dfs(int at, int depth) {
        if (depth == L) {
            int countVowels = countVowels(arr);
            if (countVowels > 0 && countVowels <= L - 2) {
                for (String str : arr) {
                    sb.append(str);
                }
                sb.append("\n");
            }
            return;
        }
    
        for (int i = at; i < C; i++) {
            arr[depth] = s[i];
            dfs(i + 1, depth + 1);
        }
    }
    
    public static int countVowels(String[] s) {
        int count = 0;
        for (String str : s)
            if (vowels.contains(str)) count++;
        
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        var line = new StringTokenizer(bf.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        s = new String[C];
        arr = new String[L];
    
        for (int i = 0; i < C; i++) {
            s[i] = line.nextToken();
        }
        Arrays.sort(s);
        
        dfs(0, 0);
        System.out.println(sb);
        bf.close();
    }
}
