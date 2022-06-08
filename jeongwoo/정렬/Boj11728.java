import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * [11728] 배열 합치기
 * https://www.acmicpc.net/problem/11728
 *
 * -아이디어
 * 1. 배열 사이즈 N, M을 입력 받고, 각 배열 원소들을 ArrayList 저장한다.
 * 2. ArrayList를 Sort한다. (Tim Sort = 삽입 + 합병)
 *
 * -시간 복잡도
 * 1. O(nlog(n))
 *
 */

public class Boj11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrayList);

        for (int x : arrayList) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);

    }
}
