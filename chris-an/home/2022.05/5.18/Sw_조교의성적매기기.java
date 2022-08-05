import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sw_조교의성적매기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] score = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            //ArrayList<Integer> al = new ArrayList<>();
            Map<Integer, Integer> hm = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int midterm = (int) (Integer.parseInt(st.nextToken()) * 0.35);
                int finals = (int) (Integer.parseInt(st.nextToken()) * 0.45);
                int task = (int) (Integer.parseInt(st.nextToken()) * 0.2);

                int sum = midterm + finals + task;
                hm.put(i, sum);
            }

            List<Integer> listKeySet = new ArrayList<>(hm.keySet());
            Collections.sort(listKeySet, (v1, v2) -> (hm.get(v2).compareTo(hm.get(v1))));

            int idx = N / 10;
            int i = 0;
            for (int key : listKeySet) {
                //System.out.println(key + " : " + (i / idx) + "/" + score[i/idx] + " : " + hm.get(key));
                if (key == K) System.out.println("#" + tc + " " +score[i/idx]);
                i++;
            }
        }
    }
}
