package language.java.Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Pro_12915 {
    // 문자열 내마음대로 정렬하기
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int num = a.charAt(n) - b.charAt(n);

                // 예제 2번 입출력 참고. (문자가 같을 경우 처리)
                if(a.charAt(n) == b.charAt(n)) return a.compareTo(b);
                else return num;
            }
        });
        return strings;
    }
    public static void main(String[] args) {

    }
}
