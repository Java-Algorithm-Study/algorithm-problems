import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [1476] 날짜 계산
 * https://www.acmicpc.net/problem/1476
 *
 * -아이디어
 * 1. 각 자리는 15, 28, 19 주기로 돌아감
 * 2. 1, 2, 3인 경우
 * 3. -> 1은 15로 나누었을 때 나머지가 1인 숫자들의 집합 1, 16, 31, ..., 5266, ...
 * 4. -> 2는 28로 나누었을 때 나머지가 2인 숫자들의 집합 2, 30, 58, ..., 5666, ...
 * 5. -> 3은 19로 나누었을 때 나머지가 3인 숫자들의 집합 3, 22, 41, ..., 5666, ...
 * 6. 나머지가 각 자리 수인 숫자들의 집합 중에 같은 자리에 같은 숫자가 나올 때까지 돌린다.
 * 7. 그러나 각 자리 수가 15, 28, 19인 경우 15 % 15 = 0이 돼서 못 찾으니까 0으로 바꿔야 한다.
 * 
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int years = 1;

        if (arr[0] == 15) {
            arr[0] = 0;
        }
        if (arr[1] == 28) {
            arr[1] = 0;
        }
        if (arr[2] == 19) {
            arr[2] = 0;
        }

        while ((arr[0] != years % 15) || (arr[1] != years % 28) || (arr[2] != years % 19)) {
            years++;
        }

        System.out.println(years);



    }
}
