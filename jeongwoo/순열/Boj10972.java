import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [10972] 다음 순열
 * https://www.acmicpc.net/problem/
 *
 * -아이디어
 * 1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾는다.
 * -> 7 2 3 6 5 4 1 경우에 3 < 6. 찾는 이유는 6 오른쪽으로는 다 내림차순이니까. 여기보다 더 큰 수는 없음. i = 3
 * 2. j >= i이면서 A[j] > A[i-1]을 만족하는 가장 작은 j를 찾는다.
 * -> 7 2 3 6 5 4 1 경우에 A[j] = 4. 이유는 현재 숫자보다 딱 하나 다음 수열을 구해야 되기 때문에 A[i-1]보다 큰 가장 작은 수를 찾는 거.
 * 3. A[i-1]과 A[j]를 swap한다.
 * -> 자리 바꿔 주고 7 2 '4' 6 5 '3' 1
 * 4. A[i]부터 순열을 뒤집는다.
 * -> 바꾼 자리 뒤에는 다 사전순으로 정렬해 줘야 돼서 뒤집는다.  7 2 4 '1 3 5 6'
 *
 * -시간 복잡도
 * 1. O(N)
 *
 * -자료 구조
 * 1.
 */

public class Boj10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation(input)) {
            for (int x : input) {
                sb.append(x).append(' ');
            }
        }
        else {
            sb.append(-1);
        }

        System.out.println(sb);

    }

    private static boolean nextPermutation(int[] input) {
        // 1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾는다.
        int i = input.length - 1;
        while (i > 0 && input[i-1] > input[i]) {
            i--;
        }
        // 마지막 순열인 경우
        if (i == 0) {
            return false;
        }

        // 2. j >= i이면서 A[j] > A[i-1]을 만족하는 가장 작은 j를 찾는다.
        int j = input.length - 1;
        while (input[j] < input[i-1]) {
            j--;
        }

        // 3. A[i-1]과 A[j]를 swap한다.
        swap(input, i-1, j);

        // 4. A[i]부터 순열을 뒤집는다.
        j = input.length - 1;
        while (i < j) {
            swap(input, i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
