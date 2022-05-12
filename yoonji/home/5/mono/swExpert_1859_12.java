import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swExpert_1859_12 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T= br.read();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = br.read();
            int[] price = new int[N];
            int sum = 0;
            String[] tmp = br.readLine().split(" ");

            for (int i=0; i<tmp.length;i++) {
                price[i] = Integer.parseInt(tmp[i]);
            }
            int max = price[price.length-1];
            for (int i=price.length-2; i>=0; i--) {
                if (price[i] > max) max = price[i];
                else if (price[i] < max) sum += max - price[i];
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}
