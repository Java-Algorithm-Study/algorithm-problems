// dp
// 각 행에서 각 열이 갖을 수 있는 최댓값?
// 첫행은 똑같고
// 두번째 행부터, [1][0]이 갖을 수 있는 최댓값은 [0]행 중 [0]열 제외한 값중 큰값 5와 현재 값5 더한 10
// 각 행은 4-1개 * 100,000 번 비교
// dp[R][C] = dp[R-1][C를 제외한 행들] 중 max값 + land[R][C]
class prg_땅따먹기 {
    int solution(int[][] land) {
        int N = land.length;
        int[][] dp = new int[N][4];
        for (int i=0; i<4; i++) {
            dp[0][i] = land[0][i];
        }
        // 두번째부터 N행까지 돌면서 dp 끝까지 돌고, 마지막 행에서 최댓값 구하기
        for (int r=1; r<N; r++) {
            for (int c=0; c<4; c++) {
                int maxOfBeforeSpaces = -1;
                // c가 0인 경우, 1~3의 값 중 최댓값 구해서 dp
                for (int i=0; i<4; i++) {
                    if (c==i) continue;
                    maxOfBeforeSpaces = Math.max(maxOfBeforeSpaces, dp[r-1][i]);
                }
                dp[r][c] = maxOfBeforeSpaces + land[r][c];
            }
        }
        int maxResult = Integer.MIN_VALUE;
        for (int i=0; i<4; i++) {
            maxResult = Math.max(maxResult, dp[N-1][i]);
        }
        return maxResult;
    }
}