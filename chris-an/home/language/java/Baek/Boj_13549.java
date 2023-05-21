package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Boj_13549 {
    static final int limit = 100_001;
    static int[] distance = new int[100_001];
    static int N, K;
    static LinkedList<Integer> qu = new LinkedList<>(); // bfs 를 위한 자료구조

    private static void bfs() {
        qu.offer(N);

        distance[N] = 0;
        while (!qu.isEmpty()) {
            int point = qu.poll();

            if (point == K) return;

            int case3 = point * 2;
            if (case3 < limit && distance[case3] == -1) {
                qu.addFirst(case3); // 0, 1 가중치 때문에, 0가중치가 제일 앞으로 들어가야 최소로 구할 수 있스빈다.
                distance[case3] = distance[point];
            }

            int case2 = point - 1;
            if (case2 >= 0 && distance[case2] == -1) {
                qu.offer(case2);
                distance[case2] = distance[point] + 1;
            }

            int case1 = point + 1;
            if (case1 < limit && distance[case1] == -1) {
                qu.offer(case1);
                distance[case1] = distance[point] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        /*
             -1 로 전체 초기화를 한 이유는 다른 숨바꼭질 1, 4 처럼
             0 으로 초기화하고 미방문 노드를 방문할 때 이전 노드에서 시간을 더해줄 시,
             더 적은 시간으로 도달할 수 있는 경우를 놓치게 됩니다.
         */
        Arrays.fill(distance, -1);
        bfs();
        System.out.println(distance[K]);
    }
}