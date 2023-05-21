package language.java.Programmers;

import java.util.*;

public class Pro_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> arangedClothes = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            arangedClothes.put(key, arangedClothes.getOrDefault(key, 1) + 1);
        }
        for (String key : arangedClothes.keySet()) {
            answer *= arangedClothes.get(key);
        }
        // 계산한 조합이 0일 때도 포함된 수니, -1을 해주어야함.
        return answer - 1;
    }
}
