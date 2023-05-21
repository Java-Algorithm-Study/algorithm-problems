package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * Z (1074)
 * https://www.acmicpc.net/problem/1074
 *
 * 최악이 되는 건, 32768 * 32768 board 에 r = 32767, c = 32767 일 경우가 될 겁니다.
 * 그러면, 1,073,676,289  10억이 넘어간다.
 * 따라서 모든 수를 다 탐색하여, 미리 보드 세팅을 한 뒤, 수를 찾는 건 문제 해결이 안된다.
 * 다른 방법이 필요한데, 이 건 4구역을 나눔. 0, 1, 2, 3 구역을 나누어 구역 별로 계산을 하게끔 문제를 해결하기.
 * 시간제한은 0.5초
 */
public class Boj_1074 {
    static int number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int targetR = Integer.parseInt(st.nextToken());
        int targetC = Integer.parseInt(st.nextToken());

        N = (int)Math.pow(2, N);
        recursive(0, 0, N, targetR, targetC);
    }

    private static void recursive(int row, int col, int N, int tR, int tC) {
        // base case
        if (row == tR && col == tC) {
            System.out.println(number);
            return;
        }

        int nN;
        if (confirmBlock(row, col, tR, tC, N)) {
            nN = N / 2;
            recursive(row, col, nN, tR, tC); // 1사분면
            recursive(row, col + nN, nN, tR, tC); // 2사분면
            recursive(row  + nN, col, nN, tR, tC); // 3사분면
            recursive(row  + nN, col  + nN, nN, tR, tC); // 4사분면
        }
    }

    private static boolean confirmBlock(int row, int col, int tR, int tC, int N) {
        if (!(row <= tR && col <= tC && tR < N + row && tC < N + col)) number += N * N;
        else return true;
        return false;
    }

}
