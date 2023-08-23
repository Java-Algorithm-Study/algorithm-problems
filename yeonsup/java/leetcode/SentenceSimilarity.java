package yeonsup.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarity {

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        boolean result = false;
        int cnt = 0;

        Map<String, List<String>> pairsMap = new HashMap<>();

        similarPairs.forEach(v -> {
            List<String> a = pairsMap.get(v.get(0));
            List<String> b = pairsMap.get(v.get(1));
            if(a == null) {
                ArrayList<String> list = new ArrayList<>();
                list.add(v.get(1));
                pairsMap.put(v.get(0), list);
            } else {
                a.add(v.get(1));
            }

            if(b == null) {
                ArrayList<String> list = new ArrayList<>();
                list.add(v.get(0));
                pairsMap.put(v.get(1), list);
            } else {
                b.add(v.get(0));
            }
        });

        if(sentence1.length != sentence2.length) return false;

        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i])) {
                if(pairsMap.containsKey(sentence1[i])) {
                    for (String s : pairsMap.get(sentence1[i])) {
                        if(s.equals(sentence2[i])) {
                            cnt++;
                        }
                    }
                } else if(pairsMap.containsKey(sentence2[i])) {
                    for (String s : pairsMap.get(sentence2[i])) {
                        if(s.equals(sentence1[i])) {
                            cnt++;
                        }
                    }
                }
            } else {
                cnt++;
            }
        }

        if(cnt == sentence1.length) {
            result = true;
        }

        return result;
    }
    public static void main(String[] args) {

    }
}
