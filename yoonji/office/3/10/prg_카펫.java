import java.util.Arrays;

public class prg_카펫 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int tile = brown + yellow;
        // 제곱근까지만 반복해서 높이로 확인
        for(int h = 3; h <= Math.sqrt(tile); h++) {
            if (tile%h == 0) {
                int w = tile / h;
                // yellow= (높이-2) * (넓이-2)
                if (yellow == (h-2)*(w-2)) {
                    answer[0] = w;
                    answer[1] = h;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] solution = solution(24, 24);
        int[] solution2 = solution(8, 1);
        int[] solution3 = solution(10, 2);
        System.out.println(Arrays.toString(solution3));
    }
}
