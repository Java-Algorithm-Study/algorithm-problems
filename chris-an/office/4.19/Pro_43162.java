import java.util.LinkedList;
import java.util.Queue;

public class Pro_43162 {

    static boolean[] visited;
    static int[][] arr;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        arr = computers;
        visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                //dfs(i);
                bfs(i);
                answer++;
            }
        }
        return answer;
    }

    private static void bfs(int i) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(i);
        visited[i] = true;

        while (!qu.isEmpty()) {
            int temp = qu.poll();
            for (int j = 0; j < arr[0].length; j++) {
                if (!visited[j] && arr[temp][j] == 1) {
                    qu.offer(j);
                    visited[j] = true;
                }
            }
        }
    }

    private static void dfs(int i) {
        // base case
        if (visited[i]) return;
        // 방문처리
        visited[i] = true;

        for (int j = 0; j < arr[0].length; j++) {
            if (arr[i][j] == 1) {
                dfs(j);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, arr));
    }
}
