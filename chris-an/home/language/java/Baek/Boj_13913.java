package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_13913 {
    static final int limit = 100_001;
    static int[] distance = new int[100_001];
    static int[] trace = new int[100_001];
    static int N, K;
    static Queue<Integer> qu = new LinkedList<>(); // bfs 를 위한 자료구조
    static Stack<Integer> stk = new Stack<>(); // 역추적을 위한 자료구조
    private static int bfs() {
        qu.offer(N);

        while (!qu.isEmpty()) {
            int point = qu.poll();

            if (point == K) break;

            int case1 = point + 1;
            if (case1 < limit && distance[case1] == 0) {
                qu.offer(case1);
                distance[case1] = distance[point] + 1;
                trace[case1] = point;
            }

            int case2 = point - 1;
            if (case2 >= 0 && distance[case2] == 0) {
                qu.offer(case2);
                distance[case2] = distance[point] + 1;
                trace[case2] = point;
            }

            int case3 = point * 2;
            if (case3 < limit && distance[case3] == 0) {
                qu.offer(case3);
                distance[case3] = distance[point] + 1;
                trace[case3] = point;
            }

            // 역추적
            if (distance[K] != 0) {
                int currentIdx = K;

                while (currentIdx != N) {
                    stk.push(currentIdx);
                    currentIdx = trace[currentIdx];
                }
                stk.push(currentIdx);
                break;
            }
        }
        return distance[K];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
        if (N == K) System.out.println(N);

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop()).append(' ');
        }
        System.out.println(sb);

    }
}