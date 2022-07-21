/**
 * [42842] 카펫
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 *
 * -아이디어
 * 1. 가로 길이 x, 세로 길이 y로 두면
 * 2. xy = yellow, x+y = (brown-4) / 2
 * 3. 위와 같은 수식 두 개를 추출할 수 있다.
 * 4. 근의 공식 사용해서 더 큰 값을 가로, 작은 값을 세로에 저장하였다.
 *
 */

public class Pro42842Again {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = (brown - 4) / 2;
        int multiply = yellow;

        int a = 1;
        int b = -sum;
        int c = multiply;

        int root = (int) Math.sqrt((b * b)-(4 * a * c));
        int x1 = (-b + root) / (2*a);
        int x2 = (-b - root) / (2*a);

        if (x1 > x2) {
            answer[0] = x1 + 2;
            answer[1] = x2 + 2;
        }
        else {
            answer[0] = x2 + 2;
            answer[1] = x1 + 2;
        }

        return answer;
    }
}
