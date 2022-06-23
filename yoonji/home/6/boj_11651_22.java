import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11651_22 {
    static int[][] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            arr[i][0] = Integer.parseInt(line.split(" ")[0]);
            arr[i][1] = Integer.parseInt(line.split(" ")[1]);
        }
        sorted = new int[N][2];
        sort(N-1, arr);
        StringBuilder sb = new StringBuilder();
        for (int[] xy : arr) sb.append(xy[0]).append(" ").append(xy[1]).append("\n");
        System.out.println(sb);
        sorted = null;
    }
    // 0 3 5 7
    private static void sort(int lastIdx, int[][] arr) {
        for (int size = 1; size<= lastIdx; size+=size) {
            for (int leftStart = 0; leftStart<= lastIdx-size; leftStart+=(2*size)) {
                int mid = leftStart+size-1;
                int last = Math.min(leftStart + (2*size)-1, lastIdx);
                mergeSort(arr, leftStart, mid, last);  // (0,0,1), (1,1,2)
            }
        }
    }
    private static void mergeSort(int[][] arr, int start, int mid, int last) {
        int rStart = mid+1, lStart = start, tmpIdx = start;
        while (lStart<=mid && rStart<= last) {
            if (arr[lStart][1] > arr[rStart][1]) {
                sorted[tmpIdx] = arr[rStart++];
            } else if (arr[lStart][1] == arr[rStart][1]) {
                if (arr[lStart][0] > arr[rStart][0]) sorted[tmpIdx] = arr[rStart++];
                else sorted[tmpIdx] = arr[lStart++];
            } else {
                sorted[tmpIdx] = arr[lStart++];
            }
            System.out.println("비교 인덱스: 왼쪽"+lStart+", 오른쪽"+rStart+"대입된 index: "+tmpIdx);
            tmpIdx++;
        }
        if (lStart > mid) {
            while(rStart <= last) {
                sorted[tmpIdx++] = arr[rStart++];
            }
        }
        else if (rStart > last) {
            while(lStart <= mid) {
                sorted[tmpIdx++] = arr[lStart++];
            }
        }
        //copy
        for (int i=start; i<=last; i++) {
            arr[i] = sorted[i];
        }
    }
}
