
/**
 * [12951] JadenCase 문자열 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12951
 *
 * -아이디어
 * 1. 소문자로 다 변경
 * 2. 공백 뒤에 오는 문자는 대문자로 변경한다
 */

public class Pro12951 {
    public static void main(String[] args) {

    }
    public String solution(String s) {
        // s를 다 소문자로 바꾼다.
        String temp = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        // s를 다 돌면서 공백 뒤에 있는 거라면 대문자로 변경
        for (int i = 0; i < temp.length(); i++) {
            // i == 0 이거나 앞글자가 공백이라면 대문자로 변경
            if (i == 0 || temp.charAt(i-1) == ' ') {
                sb.append(Character.toUpperCase(temp.charAt(i)));
                continue;
            }

            sb.append(temp.charAt(i));
        }

        return sb.toString();
    }
}
