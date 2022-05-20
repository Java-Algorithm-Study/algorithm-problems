// 프로그래머스 최솟값 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12941

import java.util.Arrays;

public class Pro_12941 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int sum = 0;
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[B.length - 1 - i];
        }
        
        return sum;
    }
}