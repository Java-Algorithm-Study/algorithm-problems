import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swExpert_1859_12 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());

        for(int TC = 1; TC <= T; TC++) {
            int N = Integer.parseInt(br.readLine());
            int[] price = new int[N];
            long sum = 0;   // N의 크기 주의..
            String[] tmp = br.readLine().split(" ");

            for (int i=0; i<tmp.length;i++) {
                price[i] = Integer.parseInt(tmp[i]);
            }
            int max = price[price.length-1];
            for (int i=price.length-2; i>=0; i--) {
                if (price[i] > max) max = price[i];
                else if (price[i] < max) sum += max - price[i];
            }
            System.out.println("#"+TC+" "+sum);
        }
    }
}
