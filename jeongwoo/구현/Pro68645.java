import java.util.Arrays;

/**
 * [68645] 삼각 달팽이
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 *
 * -아이디어
 * 1. 왼쪽으로 다 밀어 놓고 이차원 배열로 본다.
 * 2. 아래로 내려가는 건 열이 증가하고 (x++), 오른쪽으로 가면 행이 하나씩 증가한다. (y++)
 * 3. 대각선 위로 올라가는 건 열과 행이 하나씩 감소한다.
 * 4. 위 경우가 총 3번이 있으므로 위 세트들이 n번 반복된다.
 *
 */

public class Pro68645 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(8)));
    }

    public static int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] map = new int[n][n];

        int number = 1;
        int x = -1;
        int y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                }
                else if (i % 3 == 1) {
                    y++;
                }
                else {
                    x--;
                    y--;
                }
                map[x][y] = number++;
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    break;
                }
                answer[idx++] = map[i][j];
            }
        }


        return answer;
    }
}
