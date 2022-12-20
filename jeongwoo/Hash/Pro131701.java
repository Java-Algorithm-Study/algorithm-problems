import java.util.HashSet;
import java.util.Set;

/**
 * [131701] 연속 부분 수열 합의 개수
 * https://programmers.co.kr/learn/courses/30/lessons/131701
 *
 * -아이디어
 * 1. elements 배열을 돌면서 해당 인덱스에서 시작해서 길이가 1, 2, 3, ..., elements.length인 연속 부분 수열을 구한다.
 * 2. 구한 값은 해쉬셋에 넣어 중복을 방지한다.
 * 3. 원형 수열이니까 인덱스를 i % length로 접근한다.
 *
 * -시간 복잡도
 * 1. O(n^3) 이하 : n <= 1000
 *
 * -자료 구조
 * 1. HashSet : 정답 저장
 *
 */

public class Pro131701 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {7, 9, 1, 1, 4}));
    }

    public static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        // 부분 수열의 길이 i
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    int idx = k % elements.length;
                    sum += elements[idx];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}
