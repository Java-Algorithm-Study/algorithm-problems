package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = convertStrToInt(st.nextToken());
        int M = convertStrToInt(st.nextToken());

        List<Integer> li = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) li.add(convertStrToInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) li.add(convertStrToInt(st.nextToken()));

        Collections.sort(li);

        StringBuilder sb = new StringBuilder();
        for (int i : li) sb.append(i).append(' ');
        System.out.println(sb);

    }

    private static int convertStrToInt(String input) {
        return Integer.parseInt(input);
    }
}
