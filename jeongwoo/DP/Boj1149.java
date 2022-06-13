import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [1149] RGB 거리
 * https://www.acmicpc.net/problem/1149
 *
 * -아이디어
 * 1. 인접한 집(위아래)로는 색깔이 겹치면 안 된다.
 * 2. 위에서 R을 선택했으면 해당 줄에서는 R을 제외한 G, B 중 선택하면 된다.
 * 3. 점화식을 세워 본다면 osts[i][R] += Math.min(costs[i-1][G], costs[i-1][B])가 된다.
 * 4. 해당 줄은 윗줄에서 선택한 색깔을 제외한 색깔로 칠하면 되고, 그중 값이 더 싼 것으로 칠하면 되기 때문이다.
 *
 */

public class Boj1149 {
    private static int[][] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        costs = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {

            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, costs[costs.length - 1][i]);
        }
        System.out.println(answer);

    }
}
