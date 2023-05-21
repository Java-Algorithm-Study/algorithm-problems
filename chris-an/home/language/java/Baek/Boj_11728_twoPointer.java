package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11728_twoPointer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = covertStrToInt(st.nextToken());
        int M = covertStrToInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> aArr = new ArrayList<>();
        for (int i = 0; i < N; i++) aArr.add(covertStrToInt(st.nextToken()));
        Collections.sort(aArr);

        st = new StringTokenizer(br.readLine());
        List<Integer> bArr = new ArrayList<>();
        for (int i = 0; i < M; i++) bArr.add(covertStrToInt(st.nextToken()));
        Collections.sort(bArr);

        int aPoint = 0;
        int bPoint = 0;
        List<Integer> result = new ArrayList<>();
        while (aPoint < aArr.size() && bPoint < bArr.size()) {
            if (aArr.get(aPoint) > bArr.get(bPoint)) {
                result.add(bArr.get(bPoint));
                bPoint++;
            }else {
                result.add(aArr.get(aPoint));
                aPoint++;
            }
        }

        while (aPoint < aArr.size()) result.add(aArr.get(aPoint++));
        while (bPoint < bArr.size()) result.add(bArr.get(bPoint++));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) sb.append(result.get(i)).append(' ');
        System.out.println(sb);
    }

    private static int covertStrToInt(String input) {
        return Integer.parseInt(input);
    }
}
