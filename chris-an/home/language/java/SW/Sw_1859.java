package language.java.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // input Value Setting
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] inputData = new int[N];
            for (int j = 0; j < N; j++) {
                inputData[j] = Integer.parseInt(st.nextToken());
            }
            int max = Integer.MIN_VALUE;
            long result = 0;
            for (int k = N-1; k >= 0; k--) {
                if (max > inputData[k]) {
                    result += max - inputData[k];
                } else {
                    max = inputData[k];
                }
            }
            System.out.println("#" + (i+1) + " " + result);
        }
    }
}
