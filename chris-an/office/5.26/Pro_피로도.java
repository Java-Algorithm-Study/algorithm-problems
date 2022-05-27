public class Pro_피로도 {
    int max = Integer.MIN_VALUE;
    boolean[] visited;

    private void dfs(int depth, int k, int[][] dungeons) {
        // base case
        if(depth == dungeons.length) {
            max = depth;
            return;
        }
        // recur
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (k < dungeons[i][0]) {
                max = Math.max(max, depth);
                continue;
            }
            visited[i] = true;
            int temp = k - dungeons[i][1];
            dfs(depth + 1, temp , dungeons);
            visited[i] = false;
        }
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return max;
    }
    public static void main(String[] args) {
        Pro_피로도 t = new Pro_피로도();
        //int solution = t.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        int solution2 = t.solution(40, new int[][]{{40, 20}, {10, 10}, {10, 10}, {10, 10}, {10, 10}});
//        System.out.println(solution);
        System.out.println(solution2);
    }
}