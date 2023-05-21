package language.java.Programmers;

public class Pro_70128 {
    public int solution(int[] a, int[] b) {

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }
}
