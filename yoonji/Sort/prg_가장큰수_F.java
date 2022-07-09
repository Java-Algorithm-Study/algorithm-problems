package Sort;
// 원소: 0~1000
// 9 5 34 3 30
// 6 2 10
// 330 333
// - 주의할 점
// 1. String 비교 시, equals() 사용
// 2. 두 수를 비교할 때 직접 조합을 해보고 비교한다.
// 3. 정답은 숫자로 받은 것을 너무 클 수 있으니 문자로 바꾸는 것

import java.util.Arrays;
import java.util.Comparator;
public class prg_가장큰수_F {
    public String solution(int[] numbers) {
        String[] numbersStr = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            numbersStr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numbersStr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);    // 330과 303 비교
            }
        });
        // System.out.println(Arrays.toString(numbersStr));
        // 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 이므로 숫자로 먼저 받는 것. 즉, 0000 => 0 => "0"
        if (numbersStr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String str: numbersStr) {
            sb.append(str);
        }
        return sb.toString();
    }
}