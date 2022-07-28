public class Pro_타겟멤버 {
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return count;
    }

    public void dfs(int[] numbers, int depth, int target, int accrueValue) {
        if (depth == numbers.length) {
            if (target == accrueValue) count++;

            return;
        }

        dfs(numbers, depth+1, target, accrueValue + numbers[depth]);
        dfs(numbers, depth+1, target, accrueValue - numbers[depth]);
    }

}
