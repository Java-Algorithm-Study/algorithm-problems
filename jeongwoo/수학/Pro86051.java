/**
 * [86051] 없는 숫자 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/86051
 */

public class Pro86051 {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,6,7,8,0};
        System.out.println(solution(input));
    }
    public static int solution(int[] numbers) {
        int answer = 0;
        boolean[] checked = new boolean[10];

        for (int i = 0; i < numbers.length; i++) {
            checked[numbers[i]] = true;
        }

        for (int i = 0; i < 10; i++) {
            if (!checked[i])
                answer += i;
        }
        return answer;
    }
}
