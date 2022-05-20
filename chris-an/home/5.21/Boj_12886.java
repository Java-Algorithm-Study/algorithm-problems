import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_12886 {

    static Queue<StoneGroup> qu;
    static int[] arr = new int[3];
    static boolean[] permCheck = new boolean[3];
    static boolean[][] visited;
    static int result = 0; // 초기는 0 (없다)

    static class StoneGroup {
        int stone1;
        int stone2;
        int stone3;

        public StoneGroup(int stone1, int stone2, int stone3) {
            this.stone1 = stone1;
            this.stone2 = stone2;
            this.stone3 = stone3;
        }
    }

    static void calculateStone() {
        List<Integer> li = new ArrayList<>();
        int ex = 0;
        for (int i = 0 ; i < 3; i++) {
            if (permCheck[i]) li.add(arr[i]);
            else ex = arr[i];
        }
        if (li.get(0) == li.get(1)) return;

        int small = Math.min(li.get(0), li.get(1));
        int big = Math.max(li.get(0), li.get(1));
        int newStoneA = small + small;
        int newStoneB = big - small;

        if (!visited[small][big]) {
            visited[small][big] = true;
            visited[big][small] = true;
            qu.offer(new StoneGroup(newStoneA, newStoneB, ex));
        }
    }

    static void dfs(int start, int depth) {
        if (depth == 2) {
            calculateStone();
            return;
        }

        for (int i = start; i < 3; i++) {
            permCheck[i] = true;
            dfs(i + 1, depth + 1);
            permCheck[i] = false;
        }
    }

    static void bfs() {
        while (!qu.isEmpty()) {
            StoneGroup sg = qu.poll();
            int a = sg.stone1;
            int b = sg.stone2;
            int c = sg.stone3;
            if (a > 1000 || b > 1000 || c > 1000) continue;

            if (a == b && b == c) {
                result = 1;
                return;
            }
            arr = new int[3];
            permCheck = new boolean[3];
            arr[0] = a; arr[1] = b; arr[2] = c;

            dfs(0, 0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[1001][1001];
        qu = new LinkedList<>();
        qu.offer(new StoneGroup(arr[0], arr[1], arr[2]));
        bfs();
        System.out.println(result);
    }
}
