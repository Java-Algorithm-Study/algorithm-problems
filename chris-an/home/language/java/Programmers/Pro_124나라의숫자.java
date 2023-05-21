package language.java.Programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 * 한 시간 이상 걸려서 stop. 이후 기존에 풀었던 풀이 참고 함.
 * 접근 방식이 잘못되서 예외처리가 더 많아졌음.
 *
 */

public class Pro_124나라의숫자 {
    public String solution(int n) {
        StringBuilder convert123Scale = new StringBuilder();
        while(n != 0) {
            int remainder = n % 3;
            if (remainder == 0) {
                remainder = 4;
                convert123Scale.append(remainder);
                n = (n / 3) - 1;
            }else {
                convert123Scale.append(remainder);
                n /= 3;
            }
        }

        return convert123Scale.reverse().toString();
    }

}
