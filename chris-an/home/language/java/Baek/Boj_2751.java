package language.java.Baek;

import java.util.*;

/**
 * 수 정렬하기2 (2751)
 * https://www.acmicpc.net/problem/2751
 *
 * Collections.sort() 는 Timsort 이다.
 *     합병 및 삽입 정렬 알고리즘을 사용하는데, 합병일 땐, 최선, 최악 모두 O(nlogn) 을 보장하고, 삽입 일땐, O(n)을 보장한다.
 *                                     삽입일 땐, 최선은 O(n)이며, 최악은 O(n제곱) 이다.
 *
 *
 */
public class Boj_2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < N; i++) hs.add(sc.nextInt());

        /* 1.
         TreeSet<Integer> sortSet = new TreeSet<>();
         sortSet.addAll(hs);
         */

        // 2
        List<Integer> sortSet = new ArrayList<>(hs);
        Collections.sort(sortSet);
        StringBuilder sb = new StringBuilder();
        for (int i : sortSet)
            sb.append(i).append('\n');

        System.out.println(sb);
    }
}
