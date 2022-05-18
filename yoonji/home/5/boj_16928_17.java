import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// bfs로 생각해보자..
public class boj_16928_17 {
    static boolean[] visited = new boolean[101];
    static int[] cnt = new int[101];
    static int[] laddersAndSnakes = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int laddersNum = strToInt(line[0]);
        int snakesNum = strToInt(line[1]);
//        Map<Integer, Integer> ladderInfos = new HashMap<>();
//        Map<Integer, Integer> snakeInfos = new HashMap<>();
//        for (int i=0; i<laddersNum; i++) {
//            line = br.readLine().split(" ");
//            ladderInfos.put(strToInt(line[0]), strToInt(line[1]));
//        }
//        for (int i=0; i<snakesNum; i++) {
//            line = br.readLine().split(" ");
//            snakeInfos.put(strToInt(line[0]), strToInt(line[1]));
//        }
        for (int i=0; i<laddersNum+snakesNum; i++) {
            line = br.readLine().split(" ");
            int first = strToInt(line[0]);
            int sec = strToInt(line[1]);
            laddersAndSnakes[first] = sec;
        }
        bfs();
    }

    // 1부터 6까지 주사위를 던지면서
        // 옮겨진 위치에서 snake나 ladder가 있으면 이동
            // 그 곳이 방문한 곳이면 pass, 방문안했으면 que에 넣는다.
        // snake, ladder 없으면 그냥 그곳을 que에 넣고, cnt+1 지정
    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        visited[1] = true;
        cnt[1] = 0;

        while (!que.isEmpty()) {
            int curr = que.poll();
            if (curr == 100) {
                System.out.println(cnt[curr]);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if (next > 100) continue;
                if (visited[next]) continue;
                visited[next] = true;
                if (laddersAndSnakes[next] != 0) {
                    if (!visited[laddersAndSnakes[next]]) {
                        visited[laddersAndSnakes[next]] = true;
                        que.offer(laddersAndSnakes[next]);
                        cnt[laddersAndSnakes[next]] = cnt[curr] + 1;
                    }
                } else {
                    que.offer(next);
                    cnt[next] = cnt[curr] + 1;
                }
            }
        }
    }

    private static int strToInt(String s) {
        return Integer.parseInt(s);
    }
}
