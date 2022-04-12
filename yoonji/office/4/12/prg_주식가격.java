import java.util.Arrays;

public class prg_주식가격 {
    public int[] solution(int[] prices) {
        // 0. 초기화
        int[] answer = new int[prices.length];
        // 1. 반복 like 흐르는 초
        for(int i=0; i<prices.length; i++) {
            // 2. 비교위해 반복
            for (int j=i+1; j<prices.length; j++) {
                // 3. 비교
                answer[i]++;
                if (prices[i] > prices[j]) // 작은 경우
                    break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        prg_주식가격 t = new prg_주식가격();
        int[] solution = t.solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(solution));
    }
}