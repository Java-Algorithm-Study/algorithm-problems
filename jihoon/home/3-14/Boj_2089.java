import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_2089 {
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        if(n == 0)
            System.out.println(n);

        while(n != 0) {
            list.add(Math.abs(n % -2));
            n = (int) Math.ceil((double) n / -2);
        }

        for(int i = list.size() - 1; i >= 0; i--)
            System.out.print(list.get(i));
    }
}
