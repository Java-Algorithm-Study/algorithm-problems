import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Sw_간단한N의약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        int sqrt = (int)Math.sqrt(N);
        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                al.add(i);
                if (N / i != i)
                    al.add(N / i);
            }
        }
        Collections.sort(al);
        for (int i : al) {
            System.out.print(i + " ");
        }
    }
}
