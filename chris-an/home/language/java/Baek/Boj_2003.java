package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = convertStrToInt(st.nextToken());
        int M = convertStrToInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] inputDataArr = new int[N];
        for (int i = 0; i < N; i++) inputDataArr[i] = convertStrToInt(st.nextToken());
        int count = 0;
        for (int i = 0; i < N; i++) {
            int sum = inputDataArr[i];
            if (sum == M) {
                count++;
                continue;
            }
            for (int j = i + 1; j < N ; j++) {
                if (sum + inputDataArr[j] > M) break;
                if (sum + inputDataArr[j] == M) {
                    count++;
                    break;
                }
                sum += inputDataArr[j];
            }
        }
        System.out.println(count);
    }

    private static int convertStrToInt(String input) {
        return Integer.parseInt(input);
    }
}
