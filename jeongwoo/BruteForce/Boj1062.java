import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [1062] 가르침
 * https://www.acmicpc.net/problem/1062
 * 
 * -아이디어
 * 1. words 배열에서 a, n, t, i, c를 다 제외한다.
 * 2. 제외한 words 배열의 길이가 0이라면 공백을 넣어 준다.
 * 3. a, n, t, i, c를 제외한 알파벳 중에서 (k - 5)개를 뽑는다. -> 조합.
 * 4. 위의 조합에 대해 각 단어를 돌면서 뽑은 알파벳이 해당 조합에 다 있으면 cnt++ -> 하나라도 포함돼 있지 않다면 flag = false
 * 5. flag == true라면 cnt++
 * 6. words[i]가 공백이라면 무조건 읽을 수 있는 단어니까 cnt++
 * 7. 끝나면 max 비교
 *
 */

public class Boj1062 {
    private static String[] words;
    private static String[] alphabet = {"b", "d", "e", "f", "g", "h", "j", "k", "l", "m", "o", "p", "q", "r", "s", "u", "v", "w", "x", "y", "z" };
    private static boolean[] visited = new boolean[21];
    private static String[] teach;
    private static int k, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        if (k < 5) {
            max = 0;
        }
        else if (k == 26) {
            max = n;
        }
        else {
            teach = new String[k - 5];
            
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].replace("a", "")
                        .replace("c", "")
                        .replace("i", "")
                        .replace("n", "")
                        .replace("t", "");
                if (words[i].length() == 0) {
                    words[i] = " ";
                }
            }
           
            permutation(0, 0);
        }
        System.out.println(max);
    }

    private static void permutation(int start, int depth) {
        if (depth == (k - 5)) {
            int cnt = 0;
            String str = "";

            for (int k = 0; k < teach.length; k++) {
                str += teach[k];
            }
            
            for (int i = 0; i < words.length; i++) {
                boolean flag = true;
              
                if (words[i].equals(" ")) {
                    cnt++;
                    continue;
                }

                for (int l = 0; l < words[i].length(); l++) {
                    if (!str.contains(String.valueOf(words[i].charAt(l)))) {
                        flag = false;
                    }
                }
                if (flag) {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
            return;
        }

        for (int i = start; i < alphabet.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            teach[depth] = alphabet[i];
            permutation(i, depth + 1);
            visited[i] = false;
        }
    }
}
