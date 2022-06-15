import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17684
 *
 * Lv2 - KAKAO BLAND
 *  구현 쪽 문제라, 문제에서 언급한 걸 하나하나 해주면 됨.
 */
public class Pro_압축 {

    Map<String, Integer> hs = new HashMap<>();
    int dictionaryIdx;
    // Method : 초기 사전 세팅
    public void setupDictionaryContent () {
        for (int i = 1; i <= 26; i++) {
            hs.put("" + (char)(64 + i), i);
        }
        dictionaryIdx = 26;
    }
    // Method : 단어 찾기 (값이 있니? 있으면? wc 없으면 w)
    public boolean searchContent(String target) {
        return hs.containsKey(target);
    }

    public List<Integer> solution(String msg) {
        List<Integer> list = new ArrayList<>();
        // 단어가 하나만 들어왔을 시 예외 걸어주기
        if (msg.length() == 1) {
            list.add(1);
            return list;
        }

        setupDictionaryContent();
        int start = 0;
        int end = 1;
        String nContent = "";
        StringBuilder sb = new StringBuilder();
        String c ="";
        while(end < msg.length()) {
            String w = msg.substring(start, end); // 현재 글자
            c = msg.substring(end, end + 1); // 다음 한 글자.

            nContent = sb.append(w).append(c).toString();
            if(searchContent(nContent)) { // 존재해?
                end++;
            }else { // 존재 안해?
                start = end;
                end++;
                if (end < msg.length()) {
                    dictionaryIdx++;
                    hs.put(nContent, dictionaryIdx);
                }
                list.add(hs.get(w));
            }
            sb.setLength(0);
        }

        if(hs.containsKey(nContent)) list.add(hs.get(nContent));
        else list.add(hs.get(c));

        return list;
    }

    /*

    [* Pair Programming]

    public static List<Integer> solution2(String msg) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> dict = new HashMap<>();
        // 사전 초기 세팅
        int dictIdx = 1;
        for (int i = 65; i < 65 + 26; i++) {
            dict.put(String.valueOf((char) i), dictIdx++);
        }

        String temp = "";
        for (int i = 0; i < msg.length(); i++) {
            for (int j = i; j < msg.length(); j++) {
                String w = msg.substring(i, j + 1);
                if (!dict.containsKey(w)) {
                    dict.put(w, dictIdx++);
                    answer.add(dict.get(msg.substring(i, j)));
                    i = j - 1;
                    temp = "";
                    break;
                }else {
                    if (temp.length() < w.length()) temp = w;
                }
            }
        }
        answer.add(dict.get(temp));
        return answer;
    }

     */
}
