import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1062 {
    private static Set<Character> essentialAlphabets = new HashSet<>();
    private static List<Character> alphabets = new ArrayList<>();
    private static String[] words;
    private static int toChoose;
    private static List<Character> combinations = new ArrayList<>();
    private static int maxCount = -1;
    
    public static void addAlphabets() {
        essentialAlphabets.add('a');
        essentialAlphabets.add('n');
        essentialAlphabets.add('t');
        essentialAlphabets.add('i');
        essentialAlphabets.add('c');
    }
    
    public static void dfs(int start, int depth) {
        if (depth == toChoose) {
            countWords(combinations);
            return;
        }
    
        for (int i = start; i < alphabets.size(); i++) {
            combinations.add(alphabets.get(i));
            dfs(i + 1, depth + 1);
            combinations.remove(combinations.size() - 1);
        }
    }
    
    public static void countWords(List<Character> combinations) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean flag = true;
            for (int j = 4; j < word.length() - 4; j++) {
                char current = word.charAt(j);
                if (essentialAlphabets.contains(current)) continue;
                if (!combinations.contains(current)) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        maxCount = Math.max(maxCount, count);
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        words = new String[N];
        addAlphabets();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word;
            for (int j = 4; j < word.length() - 4; j++) {
                char current = word.charAt(j);
                if (!essentialAlphabets.contains(current) && !alphabets.contains(current)) {
                    alphabets.add(current);
                }
            }
        }
        toChoose = K - 5;
        if (toChoose >= 0) {
            if (alphabets.size() <= toChoose) {
                System.out.println(N);
            } else {
                dfs(0, 0);
                System.out.println(maxCount);
            }
        }
        else {
            System.out.println(0);
        }
        
    }
}
