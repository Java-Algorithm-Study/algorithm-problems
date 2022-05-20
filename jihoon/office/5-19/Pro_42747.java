import java.util.Arrays;
// H-index
public class Pro_42747 {
    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for (int i = 0; i <= citations[citations.length / 2]; i++) {
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    if (citations.length - j >= i && j + 1 <= i) {
                        max = Math.max(i, max);
                    }
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] citations = {0, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println(solution(citations));
    }
}
