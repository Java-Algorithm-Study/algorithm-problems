import java.util.Arrays;

class prg_예산 {
    public int solution(int[] d, int budget) {
        // 1. Sort
        Arrays.sort(d);

        // 2. 적은 금액부터 지원금++
        int sum = 0;
        int cnt = 0;
        for (int i=0; i<d.length; i++) {
            sum+=d[i];
            if (sum <= budget) cnt++;
        }
        return cnt;
    }
}