import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 정렬하기2
// 중복 X
// merge sort
public class boj_2751_20 {
    static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
        sorted = new int[N];
        sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int num : arr) sb.append(num).append("\n");
        System.out.println(sb);
        sorted = null;
    }
    // bottom-up
    // 크기가 점점 커짐에 따라 두 블록을 비교하여 병합하는 merge 메서드 호출
    private static void sort(int[] arr) {
        int end = arr.length-1;
        // 분할된 size= 1개, 2개, 4개, 8개, ..
        for (int size=1; size<=end; size+=size) {
            // size크기만큼 반복문 돌면서 인접 블록끼리 비교하여 병합.
            // size 1 : for문 -> (0,1), (2,3), (4,5), (6,7)
            // size 2 : for문 -> (0,3), (4,7)
            // size 4 : for문 -> (0, 7)
            for (int left = 0; left<=end-size; left+=(2*size)) {
                int mid = left + size-1; // 부분 리스트에서 right 바로 앞
                int right = Math.min(left+(2*size)-1, end);   // index때문에 -1
                merge(arr, left, mid, right);
            }
        }
    }
    // 인자로 받은 left부터 last까지 두 블록을 비교하며 병합한다.
    // 1. 왼쪽 그룹은 mid까지, 오른쪽 그룹은 last까지 index를 옮기며 비교하여 더 작은 수를 먼저 다른 배열에 넣는다.
    // 2. 둘 중 한 그룹이라도 먼저 채워졌다면, 나머지 그룹의 수들을 마저 채운다.
    private static void merge(int[] arr, int left, int mid, int last) {
        int leftIdx = left;
        int rightIdx = mid+1;
        int sortedIdx = left;
        // 1.
        while (leftIdx <= mid && rightIdx <= last) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                sorted[sortedIdx] = arr[leftIdx];
                leftIdx++;
            } else {
                sorted[sortedIdx] = arr[rightIdx];
                rightIdx++;
            }
            sortedIdx++;
        }
        // 2. 먼저 채워진 배열이 있는 경우 나머지 남은 수를 넣는다.
        if (leftIdx > mid) {
            while (rightIdx <= last) {
                sorted[sortedIdx++] = arr[rightIdx];
                rightIdx++;
            }
        } else if (rightIdx > last) {
            while (leftIdx <= mid) {
                sorted[sortedIdx++] = arr[leftIdx];
                leftIdx++;
            }
        }
        // copy
        for (int i= left; i<=last; i++)
            arr[i] = sorted[i];
    }
}
