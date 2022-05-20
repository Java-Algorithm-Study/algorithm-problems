// 프로그래머스 타겟 넘버
// https://programmers.co.kr/learn/courses/30/lessons/43165

public class Pro_43165 {
    private static int[] temp;
    private static int[] num;
    private static int targets;
    private static int count;
    
    public static void dfs(int depth) {
        if (depth == temp.length) {
            check(temp);
            return;
        }
    
        for (int i = 0; i < 2; i++) {
            temp[depth] = i;
            dfs(depth + 1);
        }
    }
    
    public static void check(int[] sign) {
        int sum = 0;
        for (int i = 0; i < sign.length; i++) {
            if (sign[i] == 0)
                sum -= num[i];
            else
                sum += num[i];
        }
        if (sum == targets) count++;
    }
    
    public static int solution(int[] numbers, int target) {
        temp = new int[numbers.length];
        num = numbers;
        targets = target;
        dfs(0);
        return count;
    }
    
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
