import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sw_중간값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            al.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(al);
        int centerNumber = al.size() / 2;
        System.out.println(al.get(centerNumber));
    }
}

/*
22 38 65 68 69 72 80 85 96
9 / 2 4

 */