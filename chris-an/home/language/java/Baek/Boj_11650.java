package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11650
 * 좌표 정렬하기 (11650)
 * 정렬 방법은 여러가지고, Collections.sort Comparator 를 사용
 */
public class Boj_11650 {
    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Coordinate> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            list.add(new Coordinate(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        /* Arrays.sort 정렬 방법
         	Arrays.sort(arr, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
        */

        Collections.sort(list, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if (o1.x == o2.x) return o1.y - o2.y;
                else return o1.x - o2.x;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Coordinate c : list) {
            sb.append(c.x).append(' ').append(c.y).append('\n');
        }
        System.out.println(sb);
    }
}