package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2529_after {

    static boolean[] visited = new boolean[10]; // 0~9까지 visited
    static int K;
    static char[] arrTemp = new char[10]; // 부등호는 최대 9개임
    static List<String> ans = new ArrayList<>();

    static boolean signsCheck(char v1, char v2, char signs) {
        if (signs == '<') {
            if (v1 > v2) return false;
        }
        if (signs == '>') {
            if (v1 < v2) return false;
        }

        return true;
    }

    static void backTracking(int depth, String num) {

        // base case
        if (depth == K + 1) {
            ans.add(num);
            return;
        }

        // recur Roof
        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;

            if (depth == 0 || signsCheck(num.charAt(depth - 1),
                                        (char) (i + '0'),
                                        arrTemp[depth - 1])) {
                visited[i] = true;
                backTracking(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arrTemp[i] = st.nextToken().charAt(0);
        }

        backTracking(0, "");

        Collections.sort(ans);

        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));

    }

}