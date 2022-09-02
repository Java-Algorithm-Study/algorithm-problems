import java.util.*;

public class Prg_압축 {
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
        String w = "", c ="";
        while(end < msg.length()) {
            w = msg.substring(start, end); // 현재 글자
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
}