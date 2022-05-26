/**
 * [87946] 피로도 
 * https://programmers.co.kr/learn/courses/30/lessons/87946
 *
 * -아이디어
 * 1. 던전 배열들로 순열을 만들어 방문할 수 있는 경우의 수를 다 탐색해 본다.
 * 2. 현재 피로도와 던전 방문 시 최소 필요 피로도를 비교해서 최소 필요 피로도보다 낮을 경우, 방문하지 못하므로 max값을 비교하고 continue;
 * 3. 방문이 가능하다면 현재 피로도에서 소모 필요도로를 빼고 dfs를 호출한다.
 *
 */
 
public class Pro87946 {
    private static int max = Integer.MIN_VALUE;
    private static boolean[] visited;

    public static void main(String[] args) {
        int[][] input = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(80, input));
    }

    private static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return max;
    }

    private static void dfs(int depth, int k, int[][] dungeons) {
        // base case
        if (depth == dungeons.length) {
            max = depth;
            return;
        }

        // recur
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (k < dungeons[i][0]) {
                max = Math.max(max, depth);
                continue;
            }
            
            visited[i] = true;
            int temp = k - dungeons[i][1];
            dfs(depth + 1, temp, dungeons);
            visited[i] = false;
        }
    }
}
