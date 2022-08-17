import java.util.*;

public class Pro_스킬트리 {
    final int ALPHA = 26;

    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        HashMap<Character, Integer> alpha = new HashMap<>();

        for (int i = 0; i < ALPHA; i++) {
            char key = (char)(65 + i);
            alpha.put(key, ALPHA);
        }

        for (int i = 0; i < skill.length(); i++) {
            char s = skill.charAt(i);
            alpha.put(s, i);
        }

        for (int i = 0; i < skill_trees.length; i++) {
            int order = 0;
            String skillOrder = skill_trees[i];
            for (int j = 0; j < skillOrder.length(); j++) {
                int a = alpha.get(skillOrder.charAt(j));

                if(a == ALPHA) continue;
                if(a != order) {
                    answer--;
                    break;
                }
                order++;
            }
        }
        return answer;
    }
}