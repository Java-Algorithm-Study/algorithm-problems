package kakao.a2018;

/**
 * [17682] 파일명 정렬
 * https://school.programmers.co.kr/learn/courses/30/lessons/17682?language=java
 *
 * -아이디어
 * 1. 입력 문자열이 숫자 -> 보너스 -> 옵션의 3가지 형태로 순차적이고 반복적이다. 문자열을 훑으면서 3가지 조건처리한다.
 *
 *
 * -시간복잡도
 * O(n)
 *
 *
 */

public class Pro_17682 {
        public static void main(String[] args) {
            int answer = 0;
            String dartResult = "1S*2T*3S";

            int[] numbers = new int[3];
            StringBuilder sb = new StringBuilder("");
            int char_index=0;
            int dart_index=0;
            char bonus, option;

            while(dart_index <=2){
                while(true){ //숫자 계산
                    if(Character.isDigit(dartResult.charAt(char_index))){
                        sb.append(dartResult.charAt(char_index));
                        char_index++;
                    }
                    else break;
                }

                bonus = dartResult.charAt(char_index);
                numbers[dart_index] = Integer.parseInt(sb.toString());
                sb.setLength(0);

                if(bonus == 'D') numbers[dart_index] = (int)Math.pow(numbers[dart_index], 2); //보너스 계산
                else if(bonus == 'T') numbers[dart_index] = (int)Math.pow(numbers[dart_index], 3);

                if(char_index == dartResult.length() -1 ) break;  //옵션 없는 마지막 다트인 경우
                char_index++;

                if(!Character.isDigit(dartResult.charAt(char_index))){ //옵션 계산
                    option = dartResult.charAt(char_index);
                    if(option == '*'){
                        numbers[dart_index] *= 2;
                        if(dart_index>=1) numbers[dart_index-1] *= 2;
                    }
                    else numbers[dart_index] *= -1;
                    char_index++;
                }

                dart_index++;
            }

            for(int i=0; i<3; i++) answer += numbers[i];
            System.out.println(answer);
        }
}
