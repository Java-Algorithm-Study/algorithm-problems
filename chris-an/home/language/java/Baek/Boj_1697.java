package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {

    static int N, K;
    static int visited[] = new int[100_001];
    static Queue<Integer> qu = new LinkedList<>();

    private static boolean check(int i) {
        // 범위 초과 시
        if(i < 0 || i > 100_000) return false;
        // 방문 했다면?
        if(visited[i] > 0) return false;

        else return true;
    }

    public static int bfs() {
        if (N == K) return 0;

        qu.add(N);

        while (!qu.isEmpty()){
            int point = qu.poll();

            if(point == K) break;

            if(check(point - 1)){
                qu.add(point - 1);
                visited[point - 1] = visited[point] + 1;
            }
            if(check(point + 1)){
                qu.add(point + 1);
                visited[point + 1] = visited[point] + 1;
            }
            if(check(point * 2)){
                qu.add(point * 2);
                visited[point * 2] = visited[point] + 1;
            }
        }

        return visited[K];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }
}