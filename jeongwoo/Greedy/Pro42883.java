
/**
 * [42883] 큰 수 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 *
 * -아이디어
 * 1. number.length() - k 개의 숫자를 찾는다.
 * 2. k + i만큼 점점 가면서 그중에서 가장 큰 숫자를 찾는다.
 *
 */

public class Pro42883 {
    public static void main(String[] args) {
        
    }
    
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int ansLength = number.length() - k;
        int index = 0;

        for (int i = 0; i < ansLength; i++) {
            int max = 0;
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }

            sb.append(max);
        }
        return sb.toString();
    }
}
