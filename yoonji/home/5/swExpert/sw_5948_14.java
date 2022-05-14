package swExpert;

import java.io.*;
import java.util.*;
public class sw_5948_14 {
    static List<Integer> sums = new ArrayList<>();
    static int[] num;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        num = new int[7];
        for (int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sums = new ArrayList<>();
            // 1. 세자리 경우의 수를 구하기 위해 첫 번째 자리에 대해 for문
            for (int i=0; i<7; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            for (int i=0; i<5; i++) {
                dfs(0, 0, i);
            }
            // 2. 내림차순 sort
            sums.sort(Collections.reverseOrder());
            bw.write("#" + t + " " + sums.get(4));bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs (int sum, int depth, int idx) {
        if (depth == 3) {
            if (!sums.contains(sum)) sums.add(sum);
            return;
        }
        for (int i=idx; i<7; i++) {
            dfs(sum+num[idx], depth+1, i+1);
        }
    }
}
