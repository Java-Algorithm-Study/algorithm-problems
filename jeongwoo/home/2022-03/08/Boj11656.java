import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [11656] 접미사 배열
 * https://www.acmicpc.net/problem/11656
 */

public class Boj11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.substring(i));
        }
        Collections.sort(list);
        for (String st : list) {
            System.out.println(st);
        }

    }
}
