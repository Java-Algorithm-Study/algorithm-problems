package Implementation;

import java.util.HashMap;
import java.util.Map;

public class prg_스킬트리 {
    Map<Character, Integer> skillsNumber = new HashMap<>();

    public int solution(String skill, String[] skill_trees) {
        initMap(skill);

        // 2. skill_trees 돌면서 순서 지켰는지 체크
        int answer = 0;
        for (String skillTree : skill_trees) {
            boolean isAnswer = true;
            int skillIdx = 0;
            int skillTreeIdx = 0;

            while (skillIdx < skill.length() && skillTreeIdx < skillTree.length()) {
                char tmpSkill = skillTree.charAt(skillTreeIdx);
                // 포함되면 체크!
                if (skillsNumber.containsKey(tmpSkill)) {

                    if (skillsNumber.get(tmpSkill) > skillIdx) {    // 현재 skill이 크면?
                        isAnswer = false;
                        break;
                    } else if (skillsNumber.get(tmpSkill) == skillIdx) {  // ==? 다음 skill
                        skillIdx++;
                    } else {
                        skillIdx = skillsNumber.get(tmpSkill);  // <? 해당 스킬넘버에 맞추기
                    }
                }
                skillTreeIdx++;
            }
            if (isAnswer) answer++;
        }
        return answer;
    }
    private void initMap(String skill) {
        int idx = 0;
        for (char s: skill.toCharArray()) {
            skillsNumber.put(s, idx++);
        }
    }
}
