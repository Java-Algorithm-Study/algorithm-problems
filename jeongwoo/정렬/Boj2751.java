import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [2751] 수 정렬하기 2
 * https://www.acmicpc.net/problem/2751
 *
 * -시간 복잡도
 * 1. Array.sort : Dual Pivot Quick Sort -> 평균 : O(nlog(n)) / 최악 : O(n^2)
 * 2. Collection.sort : TimeSort (삽입정렬과 합병정렬을 결합한 정렬) -> 평균, 최악 : O(nlog(n))
 *
 */

public class Boj2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int x : arr) {
            sb.append(x).append('\n');
        }

        System.out.println(sb);
    }
}
