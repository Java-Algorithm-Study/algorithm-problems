package DFSorBFS;
// [최소 필요, 소모] =>dungeons
// 최대한 많이 탐험.
// k: 1~5000
// 행: 1~8, 가로2
// 필요 피로도 >= 소모 피로도 : 1~1000
// 각 열이 같을 수 있다.
// k=80
// 모든 경우의 수를 구하다가 필요 피로도를 못넘기면 그때 max구해서 넣기
// 언제 basecase인가.
public class prg_피로도 {
    int maxDungeonCnt = -1;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        for (int size=dungeons.length; size>0; size--) {
            visited = new boolean[dungeons.length];
            findMaxDungeonCnt(0, size, k, dungeons);
            if (maxDungeonCnt != -1) break;
        }
        return maxDungeonCnt;
    }
    private void findMaxDungeonCnt(int depth, int size, int leftK, int[][] dungeons) {
        // basecase
        if (depth == size) {
            maxDungeonCnt = Math.max(size, maxDungeonCnt);
            return;
        }
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i]) continue;
            if (leftK < dungeons[i][0]) continue;
            visited[i] = true;
            findMaxDungeonCnt(depth+1, size, leftK-dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }
}