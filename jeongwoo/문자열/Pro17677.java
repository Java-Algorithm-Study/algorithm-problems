import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * [17677] 뉴스 클러스터링
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 *
 * -아이디어
 * 1. 문자열을 소문자로 다 변경하고, ArrayList에 글자를 두 개씩 쪼개서 넣는다.
 * 2. 교집합 str1을 기준으로 str2에 포함돼 있으면 교집합 개수++ 한 뒤, str2List에서 교집합인 문자열을 삭제한다.
 * 3. 교집합을 다 구하고 나면 str2List에는 str2 - str1만 남는다.
 * 4. 합집합은 str1 + 교집합이 없는 str2의 개수
 *
 */

public class Pro17677 {
    public static void main(String[] args) {
        String str1 = "BAAAA";
        String str2 = "AAA";

        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        String pattern = "^[a-z]*$";

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        List<String> inter = new ArrayList<>();

        for (int i = 0; i < str1.length(); i++) {
            if (i == str1.length() - 1) {
                break;
            }
            String temp = str1.substring(i, i+2);

            if (Pattern.matches(pattern, temp)) {
                str1List.add(temp);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            if (i == str2.length() - 1) {
                break;
            }
            String temp = str2.substring(i, i+2);
            if (Pattern.matches(pattern, temp)) {
                str2List.add(temp);
            }
        }

        int interCount = 0;
        int unionCount = 0;

        // 교집합
        for (int i = 0; i < str1List.size(); i++) {
            String str1Temp = str1List.get(i);

            if (str2List.contains(str1Temp)) {
                interCount++;
                str2List.remove(str1Temp);
            }
        }

        // 합집합
        unionCount += str1List.size();
        unionCount += str2List.size();;

        if (interCount == 0 && unionCount == 0) {
            return 65536;
        }

        double result = interCount / (double) unionCount;

        result *= 65536;

        return (int) result;
    }
}
