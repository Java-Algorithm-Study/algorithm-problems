public class Pro_타겟넘버 {
    static int count = 0;
    static void dfs(int depth, int calculateValue, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (calculateValue == target) count++;
            return;
        }

        dfs(depth + 1, calculateValue + numbers[depth], numbers, target);
        dfs(depth + 1, calculateValue - numbers[depth], numbers, target);
    }

    static public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return count;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;
        System.out.println(solution(numbers1, target1));
    }
}
