import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [3085] 사탕 게임
 * https://www.acmicpc.net/problem/3085
 *
 * -아이디어
 * 1. NxN 배열을 한 자리씩 바꾼다.
 * 2. 바꿀 때는 위, 아래, 왼쪽, 오른쪽을 다 바꿔야 한다.
 * 3. 바꾸고 바꾼 자리에 대해서만 사탕 개수 체크한 다음에 다시 원래 상태로 돌린다.
 * 4. 위 과정을 계속 진행하면서 max값을 찾는다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] candies = new char[n][n];

        for (int i = 0; i < n; i++) {
            candies[i] = br.readLine().toCharArray();
        }

        int max = Integer.MIN_VALUE;
        // 사탕 자리 교환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 행 변경
                if (j + 1 < n) {
                    // 자리 변경
                    swap(candies, i, j, true);
                    // max 구하기
                    int tempMax = countMax(candies, i, j);
                    // 원래 상태
                    swap(candies, i, j, true);

                    max = (tempMax > max) ? tempMax : max;
                }

                // 열 변경
                if (i + 1 < n) {
                    // 자리 변경
                    swap(candies, i, j, false);
                    // max 구하기
                    int tempMax = countMax(candies, i, j);
                    // 원래 상태
                    swap(candies, i, j, false);

                    max = (tempMax > max) ? tempMax : max;
                }
            }
        }
        System.out.println(max);
    }

    private static void swap(char[][] candies, int i, int j, boolean isRow) {
        char temp = candies[i][j];
        if (isRow) {
            candies[i][j] = candies[i][j+1];
            candies[i][j+1] = temp;
        }
        else {
            candies[i][j] = candies[i+1][j];
            candies[i+1][j] = temp;
        }
    }

    private static int countMax(char[][] candies, int i, int j) {
        int max = Integer.MIN_VALUE;

        // 행 체크
        for (int x = i; x <= i + 1; x++) {
            if (x == candies.length) {
                break;
            }
            int cnt = 1;
            for (int y = 0; y < candies.length - 1; y++) {
                if (candies[x][y] == candies[x][y+1]) {
                    cnt++;
                    max = (cnt > max) ? cnt : max;
                }
                else {
                    cnt = 1;
                }
            }
        }

        // 열 체크
        for (int x = j; x <= j + 1; x++) {
            if (x == candies.length) {
                break;
            }
            int cnt = 1;
            for (int y = 0; y < candies.length - 1; y++) {
                if (candies[y][x] == candies[y+1][x]) {
                    cnt++;
                    max = (cnt > max) ? cnt : max;
                }
                else {
                    cnt = 1;
                }
            }
        }
        return max;
    }
}
