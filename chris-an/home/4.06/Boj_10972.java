import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10972 {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void nextPermutation() {
        int idx = 0;
        int lastLen = N - 1; // 수열 인덱스 값 세팅

        // 순열은 뒤에서부터 작업이 시작됩니다.
        for (int i = lastLen; i > 0; i--) {
            if (arr[i - 1] < arr[i]) { // 현재 인덱스에서 그 전 인덱스를 비교해줍니다.
                idx = i; // 증가하는 부분 찾기
                break;
            }
        }

        if (idx == 0) {
            System.out.println(-1);
            return;
        }

        for (int i = lastLen; i >= idx; i--) {
            if (arr[idx - 1] < arr[i]) {
                swap(idx-1, i);

                // 부분정렬
                Arrays.sort(arr, idx, N);

                for (int s : arr) {
                    sb.append(s).append(" ");
                }

                System.out.println(sb);
                break;
            }
        }
    }

    static void swap(int v1, int v2) {
        int temp = arr[v1];
        arr[v1] = arr[v2];
        arr[v2] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        nextPermutation();
    }
}