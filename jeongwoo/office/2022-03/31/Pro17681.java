/**
 * [17681] 1차 비밀지도
 * https://www.acmicpc.net/problem/17681
 *
 * -아이디어
 * 1. 10진수 -> 2진수 변환 후 int
 * 2. 변환한 것끼리 비트 OR 연산 진행
 * 3. 1인 곳들을 #으로 해 줌
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Pro17681 {
    static public String[] solution(int n, int[] arr1, int[] arr2) {

        String [] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);

        }

        for (int i = 0; i < n; i++) {
            int zeroCnt = n - answer[i].length();
            String zero = "";
            while(zeroCnt-- > 0) {
                zero += "0";
            }
            answer[i] = zero + answer[i];
        }

        for (int i = 0; i < n; i++) {
            answer [i] = answer[i].replace('1', '#');
            answer [i] = answer[i].replace('0', ' ');
        }

        return answer;
    }

}
