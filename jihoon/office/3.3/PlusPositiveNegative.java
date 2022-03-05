public class PlusPositiveNegative {
    private static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] absolutes = {1, 2, 3};
        boolean[] sign = {false,false,true};
        System.out.println(solution(absolutes, sign));
    }
}
