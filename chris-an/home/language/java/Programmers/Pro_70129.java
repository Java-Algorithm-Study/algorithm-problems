package language.java.Programmers;

public class Pro_70129 {
    /*
    1. 0을 제거하면서, 모든 0을 제거한 값과, 제거한 0을 cnt로 체크해주기
    2. 0을 제외한 1만 담긴 문자열 길이 확인 후 그 길이로 2진수 변환
    3. 위 과정을 이진수가 1이 나올 때까지 반복
*/
    static public int [] solution(String s) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int oneCnt = 0;
        int totalCnt = 0;

        while (oneCnt != 1) {
            // 0 . 1 분배
            oneCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCnt++;
                }
                else {
                    oneCnt++;
                }
            }
            totalCnt++;
            // 2진법 처리
            s = Integer.toBinaryString(oneCnt);
        }
        answer[0] = totalCnt;
        answer[1] = zeroCnt;

        return answer;
    }
}
