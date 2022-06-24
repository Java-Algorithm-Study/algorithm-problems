import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_1062 {
    static int N, K;
    static boolean[] visited = new boolean[26];
    static HashSet<Character> hs = new HashSet<>();
    static ArrayList<Character> al = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static String[] line;

    private static void dfs(int start, int depth) {
        if (depth == K - 5) {
            isEligibilityCheck();
            return;
        }

        for (int i = start; i < al.size(); i++) {
            char c = al.get(i);
            visited[c - 'a'] = true;
            dfs(i + 1, depth + 1);
            visited[c - 'a'] = false;
        }
    }

    // 알파벳을 가지고 확인합니다.
    private static void isEligibilityCheck() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            boolean flag = true;
            for (int j = 0; j < line[i].length(); j++) {
                char c = line[i].charAt(j);
                if (!visited[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        max = Math.max(max, count);
    }

    private static boolean init() {
        if (K < 5) return false;
        if (!(visited['a' - 'a'] && visited['c' - 'a'] && visited['i' - 'a'] && visited['n' - 'a'] && visited['t' - 'a'])) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        line = new String[N];
        for (int i = 0; i < N; i++) {
            line[i] = br.readLine();
            for (int j = 0; j < line[i].length(); j++) {
                hs.add(line[i].charAt(j));
            }
        }

        for (char c : hs) {
            if (c == 'a' || c == 'c' || c == 't' || c == 'i' || c == 'n') {
                visited[c - 'a'] = true;
            }else al.add(c);
        }

        // 초기화가 안될 시, return 0
        if (!init()) {
            System.out.println(0);
            return;
        }

        if (K-5 >= al.size()) max = N;
        else dfs(0, 0);
        System.out.println(max);

    }
}
