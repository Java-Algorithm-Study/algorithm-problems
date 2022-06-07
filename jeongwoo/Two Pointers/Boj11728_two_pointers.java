import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [11728] 배열 합치기 - 투 포인터
 * https://www.acmicpc.net/problem/11728
 *
 * -아이디어
 * 1. n, m 크기만큼의 입력값들을 배열에 저장한다.
 * 2. 두 배열을 투 포인터를 활용해서 정렬한다.
 *
 * -시간 복잡도
 * 1. O(n)
 *
 */

public class Boj11728_two_pointers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (p1 < n && p2 < m) {
            if (arr1[p1] <= arr2[p2]) {
                arrayList.add(arr1[p1]);
                p1++;
            }
            else {
                arrayList.add(arr2[p2]);
                p2++;
            }
        }

        // p2 남은 것 다 넣기
        if (p1 == n) {
            while (p2 < m) {
                arrayList.add(arr2[p2]);
                p2++;
            }
        }
        // p1 남은 것 다 넣기
        else {
            while (p1 < n) {
                arrayList.add(arr1[p1]);
                p1++;
            }
        }

        for (int x : arrayList) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);
    }
}
