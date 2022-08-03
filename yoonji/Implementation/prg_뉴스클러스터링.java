package Implementation;
import java.util.*;
public class prg_뉴스클러스터링 {

    public static final int TIMES_NUM = 65536;
    public static HashMap<String, Integer> map1 = new HashMap<>();
    public static HashMap<String, Integer> map2 = new HashMap<>();

    public int solution(String str1, String str2) {
        // 1. 문자열로 각각 다중집합을 만든다.
        // 1-1. 다중집합 원소 중 문자가 아닌 것(공백, 등..)은 지운다.
        makeCouple(str1, map1);
        makeCouple(str2, map2);

        if (map1.size()==0 && map2.size()==0) return TIMES_NUM;

        // 2. 교집합&합집합
        int sameWordNum = 0;
        int diffWordNum = 0;

        for (String w : map1.keySet()) {
            if (map2.containsKey(w)) {
                sameWordNum += Math.min(map1.get(w), map2.get(w));
                diffWordNum += Math.max(map1.get(w), map2.get(w));
                map2.remove(w);
            } else {
                diffWordNum += map1.get(w);
            }
        }
        for (int cnt : map2.values()) {
            diffWordNum += cnt;
        }

        float ja = (float)sameWordNum / diffWordNum;
        return (int)(ja * TIMES_NUM);
    }

    private void makeCouple(String str, HashMap<String,Integer> map) {
        for (int i=0; i < str.length()-1; i++) {
            String tmp = str.substring(i,i+2).toLowerCase();
            if (isAlphabet(tmp))
                map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
    }
    private boolean isAlphabet (String substr) {
        return Character.isAlphabetic(substr.charAt(0)) && Character.isAlphabetic(substr.charAt(1));
    }
}
