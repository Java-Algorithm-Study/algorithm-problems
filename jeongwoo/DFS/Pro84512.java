import java.util.Map;
import java.util.TreeMap;

/**
 * [84512] 모음사전
 * https://programmers.co.kr/learn/courses/30/lessons/84512
 *
 * -아이디어
 * 1. dfs로 모음 사전을 만든다.
 * 2. depth >= 5가 되면 return하고, 맨 뒷글자가 변경되어야 한다.
 * 3. map에 index와 같이 넣어서 word가 있으면 value를 리턴한다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Pro84512 {
    public static Map<String, Integer> map = new TreeMap<>();
    public static String[] vowels = {"A", "E", "I", "O", "U"};
    public static int idx = 1;

    public static void main(String[] args) {
        System.out.println( solution("AAAE"));
    }

    public static int solution(String word) {
        int answer = 0;
        dfs(0, "");

        if (map.containsKey(word)) {
            answer = map.get(word);
        }
        return answer;
    }


    public static void dfs(int depth, String word) {
        if (depth >= 5) {
            return;
        }

        for (int i = 0; i < vowels.length; i++) {
//            word += vowels[i];
            map.put(word + vowels[i], idx++);
            dfs(depth + 1, word + vowels[i]);
//            word = word.substring(0, word.length() - 1);
        }
    }
}
