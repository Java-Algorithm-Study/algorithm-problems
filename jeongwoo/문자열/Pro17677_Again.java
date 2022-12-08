import java.util.ArrayList;
import java.util.List;

/**
 * [17677] 뉴스 클러스터링
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 *
 * -아이디어
 * 1. str1, str2에 대해 각각 두 글자씩 끊어서 문자열 부분 집합을 만든다.
 * 2. 만든 부분 집합에서 영문이 아닌 문자가 포함된다면 그 부분 집합은 버린다.
 * 3. 위에서 만든 부분 집합들에 대해 교집합, 합집합을 구한다.
 * 4. 합집합에는 중복된 부분 집합은 버려야 되므로 교집합이라면 str2 리스트에서는 해당 부분 집합을 삭제한다.
 *
 * -시간 복잡도
 * 1. O(n^2)
 *
 * -자료 구조
 * 1. List<String> : 문자열 부분 집합
 *
 */

public class Pro17677_Again {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
    }

    public static int solution(String str1, String str2) {
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        makeSubSet(str1List, str1);
        makeSubSet(str2List, str2);


        int inter = 0;
        // 교집합 찾기
        for (int i = 0; i < str1List.size(); i++) {
            if (str2List.contains(str1List.get(i))) {
                inter++;
                // 합집합에는 중복 없이 들어가야 되니까 교집합인 부분 집합은 한 리스트에서는 삭제한다.
                str2List.remove(str1List.get(i));
            }
        }

        // 합집합은 size 두 개 더하기
        int union = str1List.size() + str2List.size();
        if (union == 0) {
            return 65536;
        }

        double result = inter / (double) union;

        result *= 65536;

        return (int) result;
    }

    private static void makeSubSet(List<String> list, String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            String s = String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i + 1));
            if (97 <= s.charAt(0) && s.charAt(0) <= 122 && 97 <= s.charAt(1) && s.charAt(1) <= 122)  {
                list.add(s);
            }
        }
    }
}
