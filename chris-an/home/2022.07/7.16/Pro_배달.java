/**
 *  IDE 에서 작업한 코드가 아닌,
 *  프로그래머스에서 작업한 코드라
 *  IDE 에서 돌리기 위해선, static 등, 코드수정이 필요할 수도 있습니다.
 */

public class Pro_배달 {

    final int INF = 500_001;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] floyd = new int[N][N];

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j)
                    floyd[i][j] = 0;
                else
                    floyd[i][j] = INF;
            }
        }

        for (int i = 0; i < road.length; i++) {
            // 원래 있는 길이 더 적으면 pass
            if(floyd[road[i][0] - 1][road[i][1] - 1] < road[i][2]) continue;

            // 양방향 연결
            floyd[road[i][0] - 1][road[i][1] - 1] = road[i][2];
            floyd[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k) continue;
                for (int j = 0; j < N; j++) {
                    if (i == j || j == k) continue;
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }

        //for (int[] row : floyd) System.out.println(Arrays.toString(row));
        for (int i = 0; i < floyd[0].length; i++) {
            if(floyd[0][i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}
