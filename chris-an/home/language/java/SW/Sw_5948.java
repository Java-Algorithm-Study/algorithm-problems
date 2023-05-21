package language.java.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    5948. 새샘이의 7-3-5 게임 D3
*/
public class Sw_5948 {
    static ArrayList<Integer> al;
    static boolean[] visited = new boolean[7]; // 7개의 정수
    static HashSet<Integer> beforeConvert;
    static void dfs(int start, int depth) {
        // base case
        if (depth == 3) {
            permCalc();
        }
        // recur
        for (int i = start; i < al.size(); i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static void permCalc() {
        int sum = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                sum += al.get(i);
            }
        }
        beforeConvert.add(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            al = new ArrayList<>();
            while (st.hasMoreTokens()) {
                al.add(Integer.parseInt(st.nextToken()));
            }
            beforeConvert = new HashSet<>();
            dfs(0, 0);
            List afterConvert = new ArrayList(beforeConvert);
            Collections.sort(afterConvert, Collections.reverseOrder());

            System.out.println("#" + (i + 1) + " " + afterConvert.get(4));
        }
    }
}
