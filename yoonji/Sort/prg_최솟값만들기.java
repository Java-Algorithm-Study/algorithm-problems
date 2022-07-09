package Sort;
import java.util.Arrays;
public class prg_최솟값만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        // 오름차순
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i=0; i<A.length; i++) {
            answer+= A[i] * B[B.length-i-1];
        }
        return answer;
    }
}
