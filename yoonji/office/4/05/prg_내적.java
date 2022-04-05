public class prg_내적 {
    public int solution(int[] a, int[] b) {
        int sum = 0;
        for (int i=0; i<a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }
}
