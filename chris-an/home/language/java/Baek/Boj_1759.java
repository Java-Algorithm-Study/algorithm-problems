package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1759 {
    static int L,C;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static String[] arr;
    static String[] inputDataArr;
    static final String vowels = "aeiou";
    static int vowelCnt, consonant;

    public static void backTracking(int start, int depth) {

        if (depth == L) {
            vowelCnt = 0;
            consonant = 0;
            for (String s : arr) {
                if (vowels.contains(s)) vowelCnt++;
                else consonant++;
            }


            if (vowelCnt > 0 && consonant > 1) {
                for (String s : arr) {
                    sb.append(s);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = inputDataArr[i];
                backTracking(i + 1,depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[L];
        inputDataArr = new String[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine()); // C의 전체 암호를 받습니다.
        for (int i = 0; i < C; i++) {
            inputDataArr[i] = st.nextToken();
        }

        Arrays.sort(inputDataArr);

        backTracking(0,0);
        System.out.println(sb);
    }
}
