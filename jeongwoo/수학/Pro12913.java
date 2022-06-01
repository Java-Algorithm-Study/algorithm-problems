/**
 * [12913] 땅따먹기
 * https://programmers.co.kr/learn/courses/30/lessons/12913
 *
 * -아이디어
 * 1. land 0, 1, 2, 3을 돌면서 land를 이전에 저장해 둔 가장 큰 값을 찾아서 land값에 더하고 갱신한다.
 * 2. 끝나면 마지막에 land[][0], land[][1], land[][2], land[][3]을 비교해서 가장 큰 값을 호출한다.
 */

public class Pro12913 {
    public static void main(String[] args) {
        int[][] input = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(solution(input));
    }

    private static int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }

        return answer;
    }
}
