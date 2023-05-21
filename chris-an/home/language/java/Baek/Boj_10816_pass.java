package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10816_pass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numberCardArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numberCardArr[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] keyArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) keyArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numberCardArr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int lowIdx = lowerBound(keyArr[i], 0, numberCardArr.length, numberCardArr);
            int highIdx = upperBound(keyArr[i], 0, numberCardArr.length, numberCardArr);

            sb.append(highIdx - lowIdx).append(' ');
        }
        System.out.println(sb);
    }

    // 하한선
    static int lowerBound(int key, int low, int high, int[] numberCardArr) {
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (key <= numberCardArr[mid]) high = mid;
            else low = mid + 1;
        }
        return low;
    }
    // 상한선
    static int upperBound(int key, int low, int high, int[] numberCardArr) {
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (key < numberCardArr[mid]) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
