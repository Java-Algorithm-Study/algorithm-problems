import java.util.*;
import java.io.*;
/*
이해
- 0부터 시작~9,1,0 1,1 1,2 1,3
- 이진수 : 0, 1, 10(2), 11(3), 100(4), 101(5), 110(6), 111(7), 1000(8), 1001(9),
- 16진법(0~15) : 0, 2, 4, 6,  8, A(10), C(12), E(14), (16)
- 입력 : 진법 n, 출력해야할갯수 t, 참가인원m, 튜브순서 p
- 출력 : t개를 공백없이 문자열로. 10~15는 대문자 A~F로 출력
아이디어
1. 10진수를 n진수로 변환하는 방법: 반복적인 나눗셈을 통해 쌓인 나머지
2. 나머지가 10~15 인 경우 +55해서 char 알파벳으로 변경(A:65, B:66, C:67, D:68, E:69, F:70)
*/
public class prg_n진수 {
    public String solution(int n, int t, int m, int p) {
        int totalTurnLen = t*m;
        StringBuilder totalAnswer = new StringBuilder();
        StringBuilder answerOfTube = new StringBuilder();
        int num = 0;
        while(totalAnswer.length() < totalTurnLen) {
            totalAnswer.append(getTenToN(n, num));
            num++;
        }
        for (int i=p-1; i<totalTurnLen; i+=m) {
            answerOfTube.append(totalAnswer.charAt(i));
        }
        return answerOfTube.toString();
    }
    public String getTenToN (int n, int num) {
        if (num==0) return "0";
        String answerStr = "";
        while (num>0) {
            int remainder = num%n;
            if (remainder>9) {
                answerStr = (char)(remainder+55) + answerStr;
            } else answerStr = remainder + answerStr;
            num = num/n;
        }
        return answerStr;
    }
}
