import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10973 {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static void previousPermutation() {

        int idx = 0;
        int lastLen = N - 1;

        for (int i = lastLen; i > 0; i--) {
            if (arr[i-1] > arr[i]) {
                idx = i;
                break;
            }
        }

        if (idx == 0) {
            System.out.println(-1);
            return;
        }

        for (int i = lastLen; i > 0; i--) {
            if (arr[idx - 1] > arr[i]) {
                swap(idx - 1, i);

                descendingOrderSort(idx, lastLen);

                for (int s : arr) {
                    sb.append(s).append(' ');
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

    static void descendingOrderSort(int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        previousPermutation();
    }
}
