import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [10809] 알파벳 찾기
 * https://www.acmicpc.net/problem/10809
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        int[] ans = new int[26];
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (str.charAt(i) == alphabet[j]) {
                    ans[j] = str.indexOf(str.charAt(i));
                }
            }
        }

        for (int x : ans) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
      
/**
 *      for (char c = 'a'; c <= 'z'; c++) {
 *          sb.append(str.indexOf(c)).append(" ");
 *      }
 *      System.out.println(sb.toString());
 */
        
    }
}
