/**
 * [43165] 타겟 넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 *
 * -아이디어
 * 1. numbers[] 배열에 있는 값들로 +, - 연산을 통해 target을 만들어야 한다.
 * 2. numbers[]를 다 탐색했을 때 target 값과 같으면 count++
 * 3. 한 노드 값을 더하고 탐색, 그 노드 값을 빼고 탐색
 *
 */

public class Pro43165 {
    private int count;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(0, 0, numbers, target);
        return count;
    }

    private void dfs(int depth, int sum, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        dfs(depth + 1, sum + numbers[depth], numbers, target);
        dfs(depth + 1, sum - numbers[depth], numbers, target);

    }
}
