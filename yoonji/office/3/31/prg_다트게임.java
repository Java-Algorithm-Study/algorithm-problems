public class prg_다트게임 {
    public int solution(String dartResult) {
        int ans = 0;
        int[] score = new int[3];   // 점수 매길 배열
        int dartIdx = 0;
        // 1. dartResult 하나씩 방문하면서 점수[]에 변환을 준다.
        for (int i=0; i< score.length; i++) {
            // 2. 숫자
            int digit = Integer.parseInt(String.valueOf(dartResult.charAt(dartIdx)));
            if (digit == 1 && dartResult.charAt(dartIdx+1) == '0') {
                score[i] = 10;
                dartIdx++;
            }
            else score[i] = digit; // 0~9
            // 3. 보너스
            char bonus = dartResult.charAt(++dartIdx);
            if (bonus == 'D') score[i] = pow(score[i], 2);
            else if (bonus == 'T') score[i] = pow(score[i], 3);

            if (dartIdx >= dartResult.length()-1) break;    // 끝난 경우 종료.
            // 4. 옵션
            char optionOrScore = dartResult.charAt(++dartIdx);
            if (!Character.isDigit(optionOrScore)) {    // 옵션일 경우
                if (optionOrScore == '*') {
                    score[i] *= 2;
                    if (i>0) score[i-1] *= 2;
                } else { // '#'
                    score[i] *= (-1);
                }
                dartIdx++;  // index 이동(숫자로)
            }
        }
        // 5. 합
        for (int n: score) ans+= n;
        return ans;
    }
    private int pow(int i, int n) {
        return (int)Math.pow(i, n);
    }

    public static void main(String[] args) {
        prg_다트게임 t = new prg_다트게임();
        int solution = t.solution("1S*2T*3S");
        System.out.println(solution);
    }
}