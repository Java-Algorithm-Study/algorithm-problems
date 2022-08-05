import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sw_중간평균값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int sum = 0;
            ArrayList<Integer> al = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                al.add(num);
                sum += num;
            }
            Collections.sort(al);
            int max = al.remove(al.size()-1);
            sum -= max;
            int min = al.remove(0);
            sum -= min;

            //String result = String.format("%.0f", sum / (double)8);
            System.out.println("#" + tc + " " + Math.round(sum / (double) 8));

        }
    }
}
