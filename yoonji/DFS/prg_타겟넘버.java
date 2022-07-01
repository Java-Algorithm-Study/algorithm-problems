package DFS;

public class prg_타겟넘버 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        findWayCnt(numbers, 0, target, 0);
        return answer;
    }

    private void findWayCnt(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        //덧셈
        findWayCnt(numbers, depth+1, target, sum+numbers[depth]);
        //뺄셈
        findWayCnt(numbers, depth+1, target, sum-numbers[depth]);
    }
}

