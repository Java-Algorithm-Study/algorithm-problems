import java.util.Arrays;

/**
 * [42747] H-Index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 *
 * -아이디어
 * 1. 입력 배열을 오름차순 정렬한 상태로 시작한다.
 * 2. H-Index를 찾기 위해 i는 0부터 입력 배열의 중앙값까지 돈다.
 * 3. 중앙값까지 도는 이유는 중앙을 넘어가는 순간 H-Index의 후보군이 되지 못하기 때문이다.
 * 4. H-Index의 후보군인 i보다 크거나 같은 값이 있는지 입력 배열에서 확인한다. (h번 이상 인용된 논문 하나 찾는 것)
 * 5. 찾은 그 배열를 기준으로 오른쪽 (h번 이상 인용된 논문들)이 i개 이상이고, 왼쪽 (h번 이하 인용된 논문들)이 i개 이하라면 i가 H-Index다.
 * 6. max와 최댓값을 비교한다.
 * 7. H-Index에 해당 안 되는 경우도 있으니까 max가 0보다 작으면 0을 리턴한다.
 *
 */

public class Pro42747 {
    public static void main(String[] args) {
        int[] input = {3, 0, 6, 1, 5};
        System.out.println(solution(input));
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= citations[citations.length / 2]; i++) {
            for (int j = 0; j < citations.length; j++ ) {
                if (citations[j] >= i) {
                    if (citations.length - j >= i && j + 1 <= i) {
                        max = Math.max(i, max);
                    }
                }
            }

        }

        if (max < 0) {
            max = 0;
        }

        return max;
    }
}
